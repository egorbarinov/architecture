package com.egorbarinov.bankingstructure.service.fasade;

import com.egorbarinov.bankingstructure.entities.*;
import com.egorbarinov.bankingstructure.factory.coreofbankfactory.SecurityModule;
import com.egorbarinov.bankingstructure.factory.coreofbankfactory.SecurityModuleServiceImpl;
import com.egorbarinov.bankingstructure.factory.coreofbankfactory.chain_of_responsibility.*;
import com.egorbarinov.bankingstructure.service.RetailService;
import com.egorbarinov.bankingstructure.service.RetailServiceImpl;

public class ClientFasadeImpl implements ClientFasade {
    private static SecurityModule securityModule;
    private static RetailService retailService;

    public ClientFasadeImpl() {
    }

    @Override
    public boolean approveCredit(Client client, Credit credit) {

        securityModule = new SecurityModuleServiceImpl();
        Context ctx = securityModule.approveClient(client, credit);
        if (ctx.isCheck()) {
            retailService.showConsumerLoanInfo(credit);
            return  true;
        }

        return false;
    }

    public static void main(String[] args) {

        ClientFasade clientFasade = new ClientFasadeImpl();
        securityModule = new SecurityModuleServiceImpl();
        retailService = new RetailServiceImpl();


        Client client = ClientImpl.builder()
                .name("Сидоров Евгений Викторович")
                .passportId("45 06 3335555")
                .address("Russia, Moscow, Kremlin")
                .job("White House")
                .salary(80000)
                .isResident(true)
                .isWorking(true)
                .isNotCriminal(true)
                .checkForDebts(true)
                .checkNdfl(true)
                .build();

        Credit credit = ConsumerLoan.builder()
                .amount(200000.00)
                .percentage(12.5f)
                .creditPeriod(24)
                .build();

        clientFasade.approveCredit(client, credit);

    }

}
