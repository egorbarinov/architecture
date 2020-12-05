package com.egorbarinov.bankingstructure.factory;

import com.egorbarinov.bankingstructure.entities.Credit;
import java.time.LocalDate;

public interface CorporateCreditingFactory {
    Credit createCredit(Long id, String nameOfEnterprise, Integer inn, Double amount, Float percentage, Integer creditPeriod, LocalDate date);
}
