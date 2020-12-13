package com.egorbarinov.bankingstructure.factory.creditingfactory;

import com.egorbarinov.bankingstructure.entities.Credit;

public interface CreditingFactory {
    Credit createCredit(Double amount, Float percentage, Integer creditPeriod);
}
