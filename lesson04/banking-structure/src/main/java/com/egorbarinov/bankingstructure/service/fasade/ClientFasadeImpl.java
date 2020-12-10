package com.egorbarinov.bankingstructure.service.fasade;

import com.egorbarinov.bankingstructure.entities.*;
import com.egorbarinov.bankingstructure.factory.coreofbankfactory.SecurityModule;
import com.egorbarinov.bankingstructure.factory.coreofbankfactory.SecurityModuleServiceImpl;
import com.egorbarinov.bankingstructure.service.RetailService;
import com.egorbarinov.bankingstructure.service.RetailServiceImpl;

public class ClientFasadeImpl implements ClientFasade {
    private static SecurityModule securityModule;
    private static RetailService retailService;

    public ClientFasadeImpl() {
    }

    public ClientFasadeImpl(SecurityModule securityModule, RetailService retailService) {
        this.securityModule = securityModule;
        this.retailService = retailService;
    }

    @Override
    public boolean approveCredit(ClientImpl client, Credit credit) {
        if (securityModule.checkPersonForDebts(client) &&
                securityModule.checkPersonForTerrorism(client) &&
                securityModule.checkReference2NDFL()) {
           retailService.showConsumerLoanInfo(credit);
           return true;
        }
        return false;
    }

    public static void main(String[] args) {
        securityModule = new SecurityModuleServiceImpl();
        retailService = new RetailServiceImpl();

        Credit credit = new ConsumerLoan(100000.00, 12.5f, 24);
        ClientImpl client = new ClientImpl("Egor", "2222 333333", credit, "Moscow", "job Moscow",50000);

        ClientFasade clientFasade = new ClientFasadeImpl();
        if (clientFasade.approveCredit(client, credit)) {
            System.out.println("Клиенту " + "\n" + client.getInfo() + "\n" + " одобрен кредит по следующим условиям: " + credit.getInfo());
        }

    }
}
