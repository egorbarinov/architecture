package com.egorbarinov.securemodule.service;

import com.egorbarinov.securemodule.dto.ClientDto;
import com.egorbarinov.securemodule.entities.ClientImpl;
import java.io.IOException;
import java.util.List;

public interface SecurityService extends CoreOfBankFactory{
    @Override
    String getInfo();
    ClientDto assignResultOfCheck(ClientDto clientDto);
    ClientDto findById(Long id);
    boolean existById(Long id);
    boolean existByPassportId(String serial);
    ClientDto findByName(String name);
    void save(ClientImpl client);
    ClientDto findByPassportId(String serial);
    List<ClientDto> loadDataFromCreditingModule() throws IOException;
    List<ClientDto> getDataFromSecurityModule();

}
