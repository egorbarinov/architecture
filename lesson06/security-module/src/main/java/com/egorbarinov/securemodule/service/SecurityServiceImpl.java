package com.egorbarinov.securemodule.service;

import com.egorbarinov.securemodule.dto.ClientDto;
import com.egorbarinov.securemodule.entities.ClientImpl;
import com.egorbarinov.securemodule.entities.ClientStatus;
import com.egorbarinov.securemodule.repository.SecurityRepository;
import com.egorbarinov.securemodule.service.chain_of_responsibility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class SecurityServiceImpl implements SecurityService {

    private SecurityRepository repository;

    @Autowired
    public void setRepository(SecurityRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getInfo() {
        return "Security service";
    }

    @Override
    public Context checkClient(ClientDto client) {
        Context context = new Context();
        Request request = new Request(client);
        AbstractHandler handler = new StarterHandler();

        handler.addLast(new AuthHandler())
                .addLast(new SafetyHandler())
                .addLast(new DatabaseSaverHandler());
        handler.handle(context, request);
        return  context;
    }

    @Override
    public ClientImpl approveClient(ClientDto clientDto) {
        ClientImpl client = mapClientImpl(clientDto);
        client.setStatus(ClientStatus.POSITIVE);
         return client;
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
                .build();
    }

    private ClientDto mapClientImpl(ClientImpl client){
        return ClientDto.builder()
                .name(client.getName())
                .passportId(client.getPassportId())
                .address(client.getAddress())
                .job(client.getJob())
                .salary(client.getSalary())
                .isResident(client.isResident())
                .isCheckForDebts(client.isCheckForDebts())
                .build();
    }

    @Override
    public ClientDto findById(Long id) {
        ClientDto clientDto = mapClientImpl(repository.findById(id).get());
        return clientDto;
    }

    @Override
    public boolean existById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public ClientDto findByName(String name) {
        ClientDto clientDto = mapClientImpl(repository.findByName(name));
        return clientDto;
    }

    @Override
    public void save(ClientDto clientDto) {
        ClientImpl clientIml = mapClientImpl(clientDto);
        repository.save(clientIml);
        Logger.getLogger("Client saved + " + LocalDateTime.now());
    }
}
