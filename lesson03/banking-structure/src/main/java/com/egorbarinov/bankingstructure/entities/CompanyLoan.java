package com.egorbarinov.bankingstructure.entities;

import java.time.LocalDate;

public class CompanyLoan implements Credit {
    private Long id;
    private String nameOfEnterprise;
    private Integer inn;
    private Double amount;
    private Float percentage;
    private Integer creditPeriod;
    private LocalDate date;

    public CompanyLoan(Long id, String nameOfEnterprise, Integer inn, Double amount, Float percentage, Integer creditPeriod, LocalDate date) {
        this.id = id;
        this.nameOfEnterprise = nameOfEnterprise;
        this.inn = inn;
        this.amount = amount;
        this.percentage = percentage;
        this.creditPeriod = creditPeriod;
        this.date = date;
    }

    @Override
    public String getInfo() {
        return "CompanyLoan{" +
                "id=" + id +
                ", nameOfEnterprise='" + nameOfEnterprise + '\'' +
                ", inn=" + inn +
                ", amount=" + amount +
                ", percentage=" + percentage +
                ", creditPeriod=" + creditPeriod +
                ", date=" + date +
                '}';
    }

    @Override
    public String getCredit() {
        return "Компании " + nameOfEnterprise + " одобрен кредит в размере + " + amount + " сроком на " + creditPeriod + " процентная ставка " + percentage + "%";
    }
}
