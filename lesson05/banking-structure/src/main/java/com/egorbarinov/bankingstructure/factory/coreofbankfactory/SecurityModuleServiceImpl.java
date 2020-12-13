package com.egorbarinov.bankingstructure.factory.coreofbankfactory;

import com.egorbarinov.bankingstructure.entities.Client;
import com.egorbarinov.bankingstructure.entities.Credit;
import com.egorbarinov.bankingstructure.factory.coreofbankfactory.chain_of_responsibility.*;

public class SecurityModuleServiceImpl implements SecurityModule {
    @Override
    public String getInfo() {
        return "Security service";
    }

    @Override
    public Context approveClient(Client client, Credit credit) {
        Context context = new Context();
        Request request = new Request(client, credit);

        AbstractHandler handler = new StarterHandler();

        handler.addLast(new AuthHandler())
                .addLast(new SafetyHandler())
                .addLast(new DatabaseSaverHandler());
        handler.handle(context, request);
        return  context;
    }
}
