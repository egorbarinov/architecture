package com.egorbarinov.creditingmodule.service;

import com.egorbarinov.creditingmodule.dto.ClientDto;
import com.egorbarinov.creditingmodule.mapper.ClientMapper;
import com.egorbarinov.creditingmodule.repository.ClientImplRepository;
import com.egorbarinov.creditingmodule.entities.ClientImpl;
import com.egorbarinov.creditingmodule.entities.ConsumerLoan;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@Service
@EnableScheduling
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper = ClientMapper.MAPPER;

//    @Autowired
//    public void setMapper(ClientMapper clientMapper) {
//        this.clientMapper = clientMapper;
//    }

    private ClientImplRepository clientRepository;
//    private ConsumerLoanRepository consumerLoanRepository;


    @Autowired
    public void setClientRepository(ClientImplRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public ClientServiceImpl() {
    }

    private ClientImpl mapClientImpl(ClientDto clientDto){
        return ClientImpl.builder()
                .name(clientDto.getName())
                .passportId(clientDto.getPassportId())
                .address(clientDto.getAddress())
                .job(clientDto.getJob())
                .salary(clientDto.getSalary())
                .status(clientDto.getStatus())
                .isResident(clientDto.isResident())
                .isCheckNDFL(clientDto.isCheckForDebts())
                .isNotCriminal(clientDto.isNotCriminal())
                .build();
    }

    private ClientDto mapClientDtoImpl(ClientImpl client){
        return ClientDto.builder()
                .name(client.getName())
                .passportId(client.getPassportId())
                .address(client.getAddress())
                .job(client.getJob())
                .salary(client.getSalary())
                .status(client.getStatus())
                .isResident(client.isResident())
                .isCheckNDFL(client.isCheckForDebts())
                .isNotCriminal(client.isNotCriminal())
                .build();
    }


    @Override
    public ClientDto findById(Long id) {
        ClientDto clientDto = mapClientDtoImpl(clientRepository.findById(id).orElseThrow());
        return clientDto;
    }

    @Override
    public void save(ClientDto clientDto) {
        ClientImpl clientIml = mapClientImpl(clientDto);
        clientRepository.save(clientIml);
        Logger.getLogger("Client saved + " + LocalDateTime.now());
    }

    @Override
    public boolean existById(Long id) {
        return clientRepository.existsById(id);
    }

    @Override
    public boolean approveCredit(ClientDto client) {
        return true;
    }

    @Override
    public ClientDto approveClient(Long id) {
        return null;
    }

    public List<ClientDto> getAll(){
        List<ClientImpl> clients = clientRepository.findAll();
        clients.sort(Comparator.comparingLong(ClientImpl::getId));
        return clientMapper.fromClientList(clients);
    }

    @Override
    @Transactional
    @Scheduled(cron = "0 0/1 7-18 * * MON-FRI")
    public void loadDataFromSecurityModule() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL("http://localhost:8080/clients-list/clients-list-from-json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK) {
            List<ClientDto> clientDtos = mapper.readValue(url, new TypeReference<List<ClientDto>>() {
            });

            Iterator<ClientDto> iterator = clientDtos.iterator();
            while (iterator.hasNext()) {
                ClientImpl client = mapClientImpl(iterator.next());
                client.setCheckForDebts(client.isCheckForDebts());
                client.setCheckNDFL(client.isCheckNDFL());
                client.setNotCriminal(client.isNotCriminal());
                clientRepository.setClientImplInfoByPassportId(
                        client.isCheckForDebts(),
                        client.isCheckNDFL(),
                        client.isNotCriminal(),
                        client.getStatus(),
                        client.getPassportId());
            }
       }
    }


    private ConsumerLoan mapConsumerLoan(ClientDto creditData) {
//        return ConsumerLoan.builder()
//                .amount(creditData.getAmount())
//                .creditPeriod(creditData.getCreditPeriod())
//                .percentage(creditData.getPercentage())
//                .build();
        return null;
    }




}
