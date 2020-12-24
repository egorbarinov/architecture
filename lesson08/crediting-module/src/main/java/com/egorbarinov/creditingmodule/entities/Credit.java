package com.egorbarinov.creditingmodule.entities;

public interface Credit extends CreditType {
    @Override
    String getInfo();
    @Override
    String getCredit();

}
