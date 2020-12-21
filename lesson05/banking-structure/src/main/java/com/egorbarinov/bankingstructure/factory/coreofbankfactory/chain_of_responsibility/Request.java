package com.egorbarinov.bankingstructure.factory.coreofbankfactory.chain_of_responsibility;

import com.egorbarinov.bankingstructure.entities.Client;
import com.egorbarinov.bankingstructure.entities.Credit;

public class Request {

    private Client client;
    private Credit credit;

    public Request(Client client, Credit credit) {
        this.client = client;
        this.credit = credit;
    }

    public Client getClient() {
        return client;
    }

    public Credit getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return "Request{" +
                "client=" + client +
                ", credit=" + credit +
                '}';
    }
}
