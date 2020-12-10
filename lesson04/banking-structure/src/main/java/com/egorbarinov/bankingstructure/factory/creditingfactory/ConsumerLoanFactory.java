package com.egorbarinov.bankingstructure.factory.creditingfactory;

import com.egorbarinov.bankingstructure.entities.ConsumerLoan;

public class ConsumerLoanFactory implements RetailCreditingFactory {

    @Override
    public ConsumerLoan createCredit(Double amount, Float percentage, Integer creditPeriod) {
        return new ConsumerLoan(amount,percentage, creditPeriod);
    }
}

