package com.egorbarinov.bankingstructure.entities;

import java.time.LocalDate;

public class HomeLoan implements Credit {
    private Long id;
    private String consumer;
    private String passportId;
    private Double amount;
    private Float percentage;
    private Integer creditPeriod;
    private LocalDate date;
    private boolean isInsured = true;

    public HomeLoan(Long id, String consumer, String passportId, Double amount, Float percentage, Integer creditPeriod, LocalDate date) {
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
        return "HomeLoan : " + consumer + ", sum: " + amount + " period : " + creditPeriod + " percentage : " + percentage;
    }

    @Override
    public String getCredit() {
        if (isInsured) {
            percentage = percentage - 2;
        }
        return "Клиенту " + consumer + " одобрен кредит в размере + " + amount + " сроком на " + creditPeriod + " процентная ставка " + percentage + "%";
    }


}
