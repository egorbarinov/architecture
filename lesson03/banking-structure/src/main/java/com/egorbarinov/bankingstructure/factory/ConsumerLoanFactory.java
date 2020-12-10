package com.egorbarinov.bankingstructure.factory;

import com.egorbarinov.bankingstructure.entities.ConsumerLoan;
import com.egorbarinov.bankingstructure.entities.Credit;

import java.time.LocalDate;

public class ConsumerLoanFactory implements RetailCreditingFactory {

    @Override
    public Credit createCredit(Long id, String consumer, String passportId, Double amount, Float percentage, Integer creditPeriod, LocalDate date) {
        return new ConsumerLoan(id, consumer, passportId, amount, percentage, creditPeriod, date);
    }
}

