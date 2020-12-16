package com.egorbarinov.creditingmodule.factory.creditingfactory;

import com.egorbarinov.creditingmodule.entities.ConsumerLoan;

public class ConsumerLoanFactory implements RetailCreditingFactory {

    @Override
    public ConsumerLoan createCredit(Double amount, Double percentage, Integer creditPeriod) {
        return new ConsumerLoan(amount,percentage, creditPeriod);
    }
}

