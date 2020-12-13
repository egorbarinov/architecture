package com.egorbarinov.bankingstructure.factory.coreofbankfactory;

import com.egorbarinov.bankingstructure.entities.Client;
import com.egorbarinov.bankingstructure.entities.Credit;
import com.egorbarinov.bankingstructure.factory.coreofbankfactory.chain_of_responsibility.Context;

public interface SecurityModule extends CoreOfBankFactory{
    @Override
    String getInfo();

    Context approveClient(Client client, Credit credit);

}
