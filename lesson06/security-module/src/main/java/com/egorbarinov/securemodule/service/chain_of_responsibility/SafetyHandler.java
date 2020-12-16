package com.egorbarinov.securemodule.service.chain_of_responsibility;

public class SafetyHandler extends AbstractHandler {

    @Override
    public void handle(Context ctx, Request request) {
        if (request.getClient().isCheckForDebts()) {
            ctx.checkForDebts = true;
//            if (request.getClient().isheckNdfl()) {
//                ctx.checkNdfl = true;
//                ctx.check = true;
//            } else {
//                throw new IllegalArgumentException(" Справка Ндфл определена как поддельная!");
//            }
        } else {
            throw new IllegalArgumentException(" Клиент замечен в неуплате платежей по текущим кредитам");
        }
        super.handle(ctx, request);
    }
}
