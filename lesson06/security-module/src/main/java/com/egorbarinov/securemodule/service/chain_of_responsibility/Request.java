package com.egorbarinov.securemodule.service.chain_of_responsibility;

import com.egorbarinov.securemodule.dto.ClientDto;

public class Request {

    private ClientDto client;

    public Request(ClientDto client) {
        this.client = client;
    }

    public ClientDto getClient() {
        return client;
    }

}
