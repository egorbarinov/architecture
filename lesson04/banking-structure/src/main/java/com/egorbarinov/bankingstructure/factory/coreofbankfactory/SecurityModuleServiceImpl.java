package com.egorbarinov.bankingstructure.factory.coreofbankfactory;

import com.egorbarinov.bankingstructure.entities.Client;
import com.egorbarinov.bankingstructure.entities.ClientImpl;
import com.egorbarinov.bankingstructure.entities.ClientStatus;

public class SecurityModuleServiceImpl implements SecurityModule {
    @Override
    public String getInfo() {
        return "Security service";
    }

    @Override
    public boolean checkPersonForDebts(ClientImpl client) {
        System.out.println("Клиент не имеет текущих задолженностей по кредиту");
        client.setStatus(ClientStatus.POSITIVE);
        return  true;
    }

    @Override
    public boolean checkPersonForTerrorism(ClientImpl client) {
        System.out.println("Клиент не террорист");
        client.setStatus(ClientStatus.POSITIVE);
        return  true;

    }

    @Override
    public boolean checkReference2NDFL() {
//        System.out.println("Справка прошла проверку!");
        return true;
    }
}
