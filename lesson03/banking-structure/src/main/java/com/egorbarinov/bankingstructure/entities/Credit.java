package com.egorbarinov.bankingstructure.entities;

public interface Credit extends ClientCreditType{
    @Override
    String getInfo();
    @Override
    String getCredit();

}
