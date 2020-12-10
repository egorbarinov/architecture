package com.egorbarinov.bankingstructure.service;

import com.egorbarinov.bankingstructure.entities.Credit;
import com.egorbarinov.bankingstructure.factory.ConsumerLoanFactory;
import com.egorbarinov.bankingstructure.factory.HomeLoanFactory;
import com.egorbarinov.bankingstructure.factory.RetailCreditingFactory;
import java.time.LocalDate;


public class RetailServiceImpl implements RetailService {
    private RetailCreditingFactory factory ;

    public RetailServiceImpl(RetailCreditingFactory factory) {
        this.factory = factory;
    }

    @Override
    public String showHomeLoanInfo() {
        Credit credit = factory.createCredit(1L, "Egor", "2222 123456", 4000000.00, 9.2f, 120, LocalDate.now());
        return credit.getCredit();
    }

    @Override
    public String showConsumerLoanInfo() {
        Credit credit = factory.createCredit(1L, "Vasya", "3333 223322", 300000.00, 13.2f, 24, LocalDate.now());
        return credit.getCredit();
    }

    public static void main(String[] args) {
        RetailService retailService = new RetailServiceImpl(new HomeLoanFactory());
        System.out.println(retailService.showHomeLoanInfo()); // здесь происходит одна логика ( ипотека застрахована. поэтому изначальная процентная ставка уменьшена на 2% пункта

        retailService = new RetailServiceImpl(new ConsumerLoanFactory());
        System.out.println(retailService.showConsumerLoanInfo()); // а здесь нет страхования, поэтому процентная ставка не изменена
    }
}
