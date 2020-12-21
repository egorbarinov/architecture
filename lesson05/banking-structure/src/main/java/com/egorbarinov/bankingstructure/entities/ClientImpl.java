package com.egorbarinov.bankingstructure.entities;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ClientImpl implements Client {
    private Long id;
    private String name;
    private String passportId;
    private Credit credit;
    private String address;
    private String job;
    private Integer salary;
    private ClientStatus status;
    private boolean isResident = false;
    private boolean isWorking = false;
    private boolean checkForDebts = false;
    private boolean checkNdfl = false;
    private boolean isNotCriminal = false;

    public ClientImpl(Long id, String name,
                      String passportId, Credit credit,
                      String address, String job,
                      Integer salary, ClientStatus status,
                      boolean isResident, boolean isWorking,
                      boolean checkForDebts, boolean checkNdfl,
                      boolean isNotCriminal) {
        this.id = id;
        this.name = name;
        this.passportId = passportId;
        this.credit = credit;
        this.address = address;
        this.job = job;
        this.salary = salary;
        this.status = status;
        this.isResident = isResident;
        this.isWorking = isWorking;
        this.checkForDebts = checkForDebts;
        this.checkNdfl = checkNdfl;
        this.isNotCriminal = isNotCriminal;
    }

    public boolean isNotCriminal() {
        return isNotCriminal;
    }

    public void setNotCriminal(boolean notCriminal) {
        isNotCriminal = notCriminal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isResident() {
        return isResident;
    }

    @Override
    public boolean isWorking() {
        return isWorking;
    }

    public void setResident(boolean isResident) {
        this.isResident = isResident;
    }

    @Override
    public boolean checkForDebts() {
        return checkForDebts;
    }

    @Override
    public boolean checkNdfl() {
        return checkNdfl;
    }

    @Override
    public String getInfo() {
        return "ClientImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passportId='" + passportId + '\'' +
                ", credit=" + credit +
                '}';
    }
}
