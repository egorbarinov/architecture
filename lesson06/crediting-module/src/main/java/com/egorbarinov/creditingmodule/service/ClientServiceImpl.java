package com.egorbarinov.creditingmodule.service;

import com.egorbarinov.creditingmodule.dto.ClientDto;
import com.egorbarinov.creditingmodule.repository.ClientImplRepository;
import com.egorbarinov.creditingmodule.entities.ClientImpl;
import com.egorbarinov.creditingmodule.entities.ConsumerLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class ClientServiceImpl implements ClientService {

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
                .isResident(clientDto.isResident())
                .build();
    }

    private ClientDto mapClientImpl(ClientImpl client){
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
        ClientDto clientDto = mapClientImpl(clientRepository.findById(id).orElse(null));
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

    private ConsumerLoan mapConsumerLoan(ClientDto creditData) {
//        return ConsumerLoan.builder()
//                .amount(creditData.getAmount())
//                .creditPeriod(creditData.getCreditPeriod())
//                .percentage(creditData.getPercentage())
//                .build();
        return null;
    }




}
