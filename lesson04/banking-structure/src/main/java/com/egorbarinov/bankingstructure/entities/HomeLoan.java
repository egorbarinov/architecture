package com.egorbarinov.bankingstructure.entities;

public class HomeLoan implements Credit {
    private Long id;
    private Double amount;
    private Float percentage;
    private Integer creditPeriod;
    private boolean isInsured = true;


    public HomeLoan(Double amount, Float percentage, Integer creditPeriod) {
        this.amount = amount;
        this.percentage = percentage;
        this.creditPeriod = creditPeriod;
    }

    public HomeLoan(Long id, Double amount, Float percentage, Integer creditPeriod, boolean isInsured) {
        this.id = id;
        this.amount = amount;
        this.percentage = percentage;
        this.creditPeriod = creditPeriod;
        this.isInsured = isInsured;
    }

    @Override
    public String getInfo() {
        return "sum: " + amount + " period : " + creditPeriod + " percentage : " + percentage;
    }

    @Override
    public String getCredit() {
        if (isInsured) {
            percentage = percentage - 2;
        }
        return "Физическому лицу одобрен ипотечный кредит в размере + " + amount + " сроком на " + creditPeriod + " процентная ставка " + percentage + "%";
    }


}
