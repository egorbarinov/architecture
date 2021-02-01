package com.egorbarinov.creditingmodule.factory.creditingfactory;

import com.egorbarinov.creditingmodule.entities.CompanyLoan;
import com.egorbarinov.creditingmodule.entities.Credit;

public class CompanyLoanFactory implements CorporateCreditingFactory{
    @Override
    public Credit createCredit(Double amount, Double percentage, Integer creditPeriod) {
        return new CompanyLoan(amount, percentage, creditPeriod);
    }
}
