package com.egorbarinov.bankingstructure.factory.creditingfactory;

import com.egorbarinov.bankingstructure.entities.CompanyLoan;
import com.egorbarinov.bankingstructure.entities.Credit;

public class CompanyLoanFactory implements CorporateCreditingFactory{
    @Override
    public Credit createCredit(Double amount, Float percentage, Integer creditPeriod) {
        return new CompanyLoan(amount, percentage, creditPeriod);
    }
}
