package com.egorbarinov.bankingstructure.factory;

import com.egorbarinov.bankingstructure.entities.Credit;
import com.egorbarinov.bankingstructure.entities.HomeLoan;

import java.time.LocalDate;

public class HomeLoanFactory implements RetailCreditingFactory {
    @Override
    public Credit createCredit(Long id, String consumer, String passportId, Double amount, Float percentage, Integer creditPeriod, LocalDate date) {
        return new HomeLoan(id, consumer, passportId, amount, percentage, creditPeriod, date);
    }

}
