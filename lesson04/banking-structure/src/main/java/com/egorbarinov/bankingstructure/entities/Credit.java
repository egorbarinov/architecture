package com.egorbarinov.bankingstructure.entities;

public interface Credit extends CreditType {
    @Override
    String getInfo();
    @Override
    String getCredit();

}
