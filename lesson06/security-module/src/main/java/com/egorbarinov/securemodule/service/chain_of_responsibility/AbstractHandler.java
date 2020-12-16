package com.egorbarinov.securemodule.service.chain_of_responsibility;

public class AbstractHandler {
    private AbstractHandler next;

    public void handle(Context ctx, Request request) {
        if(next != null)
            next.handle(ctx, request);
    }

    public AbstractHandler addLast(AbstractHandler next) {
        this.next = next;
        return next;
    }

}
