package com.egorbarinov.bankingstructure.service;

import com.egorbarinov.bankingstructure.entities.Credit;
import com.egorbarinov.bankingstructure.factory.creditingfactory.ConsumerLoanFactory;
import com.egorbarinov.bankingstructure.factory.creditingfactory.HomeLoanFactory;
import com.egorbarinov.bankingstructure.factory.creditingfactory.RetailCreditingFactory;

public class RetailServiceImpl implements RetailService {
    private RetailCreditingFactory factory ;

    public RetailServiceImpl() {
    }

    public RetailServiceImpl(RetailCreditingFactory factory) {
        this.factory = factory;
    }

    @Override
    public String showHomeLoanInfo(Credit credit) {
//        Credit credit = factory.createCredit(4000000.00, 9.2f, 120);
        return credit.getCredit();
    }

    @Override
    public String showConsumerLoanInfo(Credit credit) {
//        Credit credit = factory.createCredit( 300000.00, 13.2f, 24);
        return credit.getCredit();
    }

    public static void main(String[] args) {
        RetailService retailService = new RetailServiceImpl(new HomeLoanFactory());
//        System.out.println(retailService.showHomeLoanInfo()); // здесь происходит одна логика ( ипотека застрахована. поэтому изначальная процентная ставка уменьшена на 2% пункта

        retailService = new RetailServiceImpl(new ConsumerLoanFactory());
//        System.out.println(retailService.showConsumerLoanInfo()); // а здесь нет страхования, поэтому процентная ставка не изменена
    }
}
