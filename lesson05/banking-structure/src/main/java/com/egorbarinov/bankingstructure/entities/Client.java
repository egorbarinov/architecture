package com.egorbarinov.bankingstructure.entities;

public interface Client {
    String getInfo();
    String getName();
    boolean isResident();
    boolean isWorking();
    boolean checkForDebts();
    boolean checkNdfl();
    boolean isNotCriminal();

}
