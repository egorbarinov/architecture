package com.egorbarinov.securemodule.service.chain_of_responsibility;

public class DatabaseSaverHandler extends AbstractHandler{
    @Override
    public void handle(Context ctx, Request request) {
//        ctx.getAmount()
        System.out.printf("Клиент %s прошел проверки и ему одобрен кредит\n", request.getClient().getName());
        super.handle(ctx, request);
    }
}
