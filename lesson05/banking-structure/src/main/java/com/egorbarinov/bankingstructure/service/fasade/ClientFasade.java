package com.egorbarinov.bankingstructure.service.fasade;

import com.egorbarinov.bankingstructure.entities.Client;
import com.egorbarinov.bankingstructure.entities.Credit;

public interface ClientFasade {
    boolean approveCredit(Client client, Credit credit);
}
