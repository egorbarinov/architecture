package com.egorbarinov.bankingstructure.entities;

import java.time.LocalDate;

public class ConsumerLoan implements Credit {
    private Long id;
    private Double amount;
    private Float percentage;
    private Integer creditPeriod;

    public ConsumerLoan(Long id, Double amount, Float percentage, Integer creditPeriod) {
        this.id = id;
        this.amount = amount;
        this.percentage = percentage;
        this.creditPeriod = creditPeriod;
    }

    public ConsumerLoan(Double amount, Float percentage, Integer creditPeriod) {
        this.amount = amount;
        this.percentage = percentage;
        this.creditPeriod = creditPeriod;
    }

    @Override
    public String getInfo() {
        return "ConsumerLoan{" +
                "id=" + id +
                ", amount=" + amount +
                ", percentage=" + percentage +
                ", creditPeriod=" + creditPeriod +
                '}';
    }

    @Override
    public String getCredit() {
        return "Сумма " + amount + " сроком на " + creditPeriod + " месяцев, процентная ставка " + percentage + "%";
    }
}
