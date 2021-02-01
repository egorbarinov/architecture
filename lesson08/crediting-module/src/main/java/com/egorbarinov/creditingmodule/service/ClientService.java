package com.egorbarinov.creditingmodule.service;

import com.egorbarinov.creditingmodule.dto.ClientDto;
import com.egorbarinov.creditingmodule.entities.ClientImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface ClientService {
    boolean approveCredit(ClientDto client);
    ClientDto approveClient(Long id);
    ClientDto findById(Long id);
    void save(ClientDto clientDto);
    boolean existById(Long id);
    List<ClientDto> getAll();
    void loadDataFromSecurityModule() throws IOException;
}
