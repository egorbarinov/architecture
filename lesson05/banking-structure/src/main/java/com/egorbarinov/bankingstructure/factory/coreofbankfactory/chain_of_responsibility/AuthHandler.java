package com.egorbarinov.bankingstructure.factory.coreofbankfactory.chain_of_responsibility;

public class AuthHandler extends AbstractHandler {

    private String correctPassword;

    @Override
    public void handle(Context ctx, Request request) {
        if (request.getClient().isResident() && request.getClient().isWorking()) {
            ctx.isResident = true;
            ctx.isWorking = true;
            System.out.printf("Клиент %s является работающим резидентом\n", request.getClient().getName());
            if (request.getClient().isNotCriminal()) {
                ctx.isNotCriminal = true;
                System.out.printf("Клиент %s не замечен в нарушении закона\n", request.getClient().getName() );
                super.handle(ctx, request);
            } else System.out.println(" У клиента не лады с законом!");

        } else {
            throw new IllegalArgumentException("Клиент не прошел базовую проверку!");
        }
    }
}
