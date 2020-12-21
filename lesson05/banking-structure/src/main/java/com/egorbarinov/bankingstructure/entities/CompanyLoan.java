package com.egorbarinov.bankingstructure.entities;

import java.time.LocalDate;

public class CompanyLoan implements Credit {
    private Long id;
    private Double amount;
    private Float percentage;
    private Integer creditPeriod;


    public CompanyLoan(Double amount, Float percentage, Integer creditPeriod) {
        this.amount = amount;
        this.percentage = percentage;
        this.creditPeriod = creditPeriod;
    }

    @Override
    public String getInfo() {
        return "CompanyLoan{" +
                ", amount=" + amount +
                ", percentage=" + percentage +
                ", creditPeriod=" + creditPeriod +
                '}';
    }

    @Override
    public String getCredit() {
        return "Компании одобрен кредит в размере + " + amount + " сроком на " + creditPeriod + " процентная ставка " + percentage + "%";
    }
}
