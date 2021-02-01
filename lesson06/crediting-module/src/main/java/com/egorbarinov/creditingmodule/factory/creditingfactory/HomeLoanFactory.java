package com.egorbarinov.creditingmodule.factory.creditingfactory;

import com.egorbarinov.creditingmodule.entities.HomeLoan;

public class HomeLoanFactory implements RetailCreditingFactory {
    @Override
    public HomeLoan createCredit(Double amount, Double percentage, Integer creditPeriod) {
        return new HomeLoan(amount, percentage, creditPeriod);
    }
}
