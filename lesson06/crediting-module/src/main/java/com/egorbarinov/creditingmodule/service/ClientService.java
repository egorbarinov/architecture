package com.egorbarinov.creditingmodule.service;

import com.egorbarinov.creditingmodule.dto.ClientDto;
import com.egorbarinov.creditingmodule.entities.ClientImpl;

public interface ClientService {
    boolean approveCredit(ClientDto client);
    ClientDto findById(Long id);
    void save(ClientDto clientDto);
    boolean existById(Long id);
}
