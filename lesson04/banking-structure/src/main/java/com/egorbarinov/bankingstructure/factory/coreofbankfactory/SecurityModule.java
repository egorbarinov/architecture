package com.egorbarinov.bankingstructure.factory.coreofbankfactory;


import com.egorbarinov.bankingstructure.entities.ClientImpl;

public interface SecurityModule extends CoreOfBankFactory{
    @Override
    String getInfo();
    boolean checkPersonForDebts(ClientImpl client);
    boolean checkPersonForTerrorism(ClientImpl client);
    boolean checkReference2NDFL();
}
