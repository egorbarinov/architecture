package com.egorbarinov.bankingstructure.factory;

import com.egorbarinov.bankingstructure.entities.CompanyLoan;
import com.egorbarinov.bankingstructure.entities.Credit;

import java.time.LocalDate;

public class CompanyLoanFactory implements CorporateCreditingFactory{
    @Override
    public Credit createCredit(Long id, String nameOfEnterprise, Integer inn, Double amount, Float percentage, Integer creditPeriod, LocalDate date) {
        return new CompanyLoan(id, nameOfEnterprise, inn, amount, percentage, creditPeriod, date);
    }
}
