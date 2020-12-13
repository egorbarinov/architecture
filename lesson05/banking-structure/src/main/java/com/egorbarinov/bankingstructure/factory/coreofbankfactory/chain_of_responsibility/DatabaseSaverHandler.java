package com.egorbarinov.bankingstructure.factory.coreofbankfactory.chain_of_responsibility;

public class DatabaseSaverHandler extends AbstractHandler{
    @Override
    public void handle(Context ctx, Request request) {
        System.out.printf("Клиент %s прошел проверки и ему одобрен кредит\n", request.getClient().getName());
        super.handle(ctx, request);
    }
}
