package com.egorbarinov.bankingstructure.factory;

import com.egorbarinov.bankingstructure.entities.Credit;

import java.time.LocalDate;

public interface RetailCreditingFactory {
    Credit createCredit(Long id, String consumer, String passportId, Double amount, Float percentage, Integer creditPeriod, LocalDate date);
}
