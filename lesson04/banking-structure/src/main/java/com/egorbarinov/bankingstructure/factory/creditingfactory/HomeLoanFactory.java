package com.egorbarinov.bankingstructure.factory.creditingfactory;

import com.egorbarinov.bankingstructure.entities.HomeLoan;

public class HomeLoanFactory implements RetailCreditingFactory {
    @Override
    public HomeLoan createCredit(Double amount, Float percentage, Integer creditPeriod) {
        return new HomeLoan(amount, percentage, creditPeriod);
    }
}
