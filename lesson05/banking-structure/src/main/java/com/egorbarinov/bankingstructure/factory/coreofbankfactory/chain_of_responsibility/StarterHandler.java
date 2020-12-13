package com.egorbarinov.bankingstructure.factory.coreofbankfactory.chain_of_responsibility;

public class StarterHandler extends AbstractHandler{
    @Override
    public void handle(Context ctx, Request request) {
        System.out.printf("Начало проведения проверки в службе безопасности: клиент %s\n", request.getClient().getName());
        super.handle(ctx, request);
    }
}
