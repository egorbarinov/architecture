package com.egorbarinov.securemodule.service.chain_of_responsibility;

public class Context {
    boolean isResident = false;
    boolean isWorking = false;
    boolean checkForDebts = false;
    boolean checkNdfl = false;
    boolean isNotCriminal = false;
    boolean check = false;
    Double amount;
    Float percentage;
    Integer creditPeriod;

    public boolean isResident() {
        return isResident;
    }

    public void setResident(boolean resident) {
        isResident = resident;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public boolean isCheckForDebts() {
        return checkForDebts;
    }

    public void setCheckForDebts(boolean checkForDebts) {
        this.checkForDebts = checkForDebts;
    }

    public boolean isCheckNdfl() {
        return checkNdfl;
    }

    public void setCheckNdfl(boolean checkNdfl) {
        this.checkNdfl = checkNdfl;
    }

    public boolean isNotCriminal() {
        return isNotCriminal;
    }

    public void setNotCriminal(boolean notCriminal) {
        isNotCriminal = notCriminal;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public Integer getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(Integer creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
