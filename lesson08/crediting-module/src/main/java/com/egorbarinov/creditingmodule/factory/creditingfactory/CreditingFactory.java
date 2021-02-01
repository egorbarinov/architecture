package com.egorbarinov.creditingmodule.factory.creditingfactory;

import com.egorbarinov.creditingmodule.entities.Credit;

public interface CreditingFactory {
    Credit createCredit(Double amount, Double percentage, Integer creditPeriod);
}
