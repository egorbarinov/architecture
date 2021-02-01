package com.egorbarinov.securemodule.service;

import com.egorbarinov.securemodule.dto.ClientDto;
import com.egorbarinov.securemodule.entities.ClientImpl;
import com.egorbarinov.securemodule.service.chain_of_responsibility.Context;

public interface SecurityService extends CoreOfBankFactory{
    @Override
    String getInfo();

    Context checkClient(ClientDto clientDto);
    ClientImpl approveClient(ClientDto clientDto);
    ClientDto findById(Long id);
    boolean existById(Long id);
    ClientDto findByName(String name);
    void save(ClientDto clientDto);

}
