package com.egorbarinov.creditingmodule.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "banking_structure", name = "credit")
public class ConsumerLoan implements Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private Long id;
    @Column(name = "credit_amount")
    private Double amount;
    @Column(name = "credit_percentage")
    private Double percentage;
    @Column(name = "credit_period")
    private Integer creditPeriod;

//    public ConsumerLoan(Long id, Double amount, Float percentage, Integer creditPeriod) {
//        this.id = id;
//        this.amount = amount;
//        this.percentage = percentage;
//        this.creditPeriod = creditPeriod;
//    }

    public ConsumerLoan(Double amount, Double percentage, Integer creditPeriod) {
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
