package com.egorbarinov.securemodule.service;

import com.egorbarinov.securemodule.dto.ClientDto;
import com.egorbarinov.securemodule.entities.ClientImpl;
import com.egorbarinov.securemodule.entities.ClientStatus;
import com.egorbarinov.securemodule.mapper.ClientMapper;
import com.egorbarinov.securemodule.repository.SecurityRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

@Service
@EnableScheduling
public class SecurityServiceImpl implements SecurityService {

    private SecurityRepository repository;
//    private ClientMapper mapper;
    private final ClientMapper mapper = ClientMapper.MAPPER;

//    @Autowired
//    public void setMapper(ClientMapper mapper) {
//        this.mapper = mapper;
//    }

    @Autowired
    public void setRepository(SecurityRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getInfo() {
        return "Security service";
    }



    @Override
    @Transactional
    public ClientDto assignResultOfCheck(ClientDto clientDto) {

        ClientImpl client = mapClientImpl(clientDto);

        if (client.isCheckForDebts() && client.isCheckNDFL() && client.isNotCriminal()) {
            client.setStatus(ClientStatus.POSITIVE);
        } else {
            client.setStatus(ClientStatus.NEGATIVE);
        }
        repository.setClientImplInfoByPassportId(
                client.isCheckForDebts(),
                client.isCheckNDFL(),
                client.isNotCriminal(),
                client.getStatus(),
                client.getPassportId());

        return mapClientDtoImpl(client);
    }


    private ClientImpl mapClientImpl(ClientDto clientDto){
        return ClientImpl.builder()
                .name(clientDto.getName())
                .passportId(clientDto.getPassportId())
                .address(clientDto.getAddress())
                .job(clientDto.getJob())
                .salary(clientDto.getSalary())
                .isResident(clientDto.isResident())
                .isCheckForDebts(clientDto.isCheckForDebts())
                .checkNDFL(clientDto.isCheckNDFL())
                .isNotCriminal(clientDto.isNotCriminal())
                .status(clientDto.getStatus())
                .build();
    }

    private ClientDto mapClientDtoImpl(ClientImpl client){
        return ClientDto.builder()
                .name(client.getName())
                .passportId(client.getPassportId())
                .address(client.getAddress())
                .job(client.getJob())
                .salary(client.getSalary())
                .isResident(client.isResident())
                .isCheckForDebts(client.isCheckForDebts())
                .checkNDFL(client.isCheckNDFL())
                .isNotCriminal(client.isNotCriminal())
                .status(client.getStatus())
                .build();
    }

    @Override
    public ClientDto findById(Long id) {
        return mapClientDtoImpl(repository.findById(id).get());
    }

    @Override
    public ClientDto findByPassportId(String serial) {
        return mapClientDtoImpl(repository.findByPassportId(serial));
    }

    @Override
    public boolean existByPassportId(String serial) {
        return repository.existsByPassportId(serial);
    }

    @Override
    public boolean existById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public ClientDto findByName(String name) {
        return mapClientDtoImpl(repository.findByName(name));
    }

    @Override
    @Scheduled(cron = "0 0/1 7-18 * * MON-FRI")
    public List<ClientDto> loadDataFromCreditingModule() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL("http://localhost:8189/clients");
        List<ClientDto> clientDtos = mapper.readValue(url, new TypeReference<List<ClientDto>>() {
        });

        Iterator<ClientDto> iterator = clientDtos.iterator();
        while (iterator.hasNext()){
            ClientImpl client = mapClientImpl(iterator.next());
            if (!repository.existsByPassportId(client.getPassportId())) {
                save(client);
            }
        }
        return clientDtos;
    }

    @Override
    public List<ClientDto> getDataFromSecurityModule() {
        return mapper.fromClientList(repository.findAll());
    }

    @Override
    public void save(ClientImpl client) {
        repository.save(client);

    }
}
