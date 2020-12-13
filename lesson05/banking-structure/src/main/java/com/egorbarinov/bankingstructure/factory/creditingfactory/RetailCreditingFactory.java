package com.egorbarinov.bankingstructure.factory.creditingfactory;

import com.egorbarinov.bankingstructure.entities.Credit;

public interface RetailCreditingFactory extends CreditingFactory {

    @Override
    Credit createCredit(Double amount, Float percentage, Integer creditPeriod);


}
