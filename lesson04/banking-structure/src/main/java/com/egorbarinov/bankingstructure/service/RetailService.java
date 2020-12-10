package com.egorbarinov.bankingstructure.service;

import com.egorbarinov.bankingstructure.entities.Credit;

public interface RetailService {
    String showHomeLoanInfo(Credit credit);
    String showConsumerLoanInfo(Credit credit);
}
