package com.egorbarinov.bankingstructure.service.fasade;

import com.egorbarinov.bankingstructure.entities.ClientImpl;
import com.egorbarinov.bankingstructure.entities.Credit;

public interface ClientFasade {
    boolean approveCredit(ClientImpl client, Credit credit);
}
