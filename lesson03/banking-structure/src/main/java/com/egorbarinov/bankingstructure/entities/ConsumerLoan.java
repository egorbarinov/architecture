package com.egorbarinov.bankingstructure.entities;

import java.time.LocalDate;

public class ConsumerLoan implements Credit {
    private Long id;
    private String consumer;
    private String passportId;
    private Double amount;
    private Float percentage;
    private Integer creditPeriod;
    private LocalDate date;

    public ConsumerLoan(Long id, String consumer, String passportId, Double amount, Float percentage, Integer creditPeriod, LocalDate date) {
        this.id = id;
        this.consumer = consumer;
        this.passportId = passportId;
        this.amount = amount;
        this.percentage = percentage;
        this.creditPeriod = creditPeriod;
        this.date = date;
    }

    @Override
    public String getInfo() {
        return "ConsumerLoan{" +
                "id=" + id +
                ", consumer='" + consumer + '\'' +
                ", passportId='" + passportId + '\'' +
                ", amount=" + amount +
                ", percentage=" + percentage +
                ", creditPeriod=" + creditPeriod +
                ", date=" + date +
                '}';
    }

    @Override
    public String getCredit() {
        return "Клиенту " + consumer + " одобрен потребительский кредит в размере + " + amount + " сроком на " + creditPeriod + " процентная ставка " + percentage + "%";
    }
}
