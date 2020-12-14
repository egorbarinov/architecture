package com.egorbarinov.bankingstructure.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
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

    public ClientImpl(Long id, String name, String passportId, Credit credit, String address, String job, Integer salary, ClientStatus status) {
        this.id = id;
        this.name = name;
        this.passportId = passportId;
        this.credit = credit;
        this.address = address;
        this.job = job;
        this.salary = salary;
        this.status = status;
    }

    public ClientImpl(String name, String passportId, Credit credit, String address, String job, Integer salary, ClientStatus status) {
        this.name = name;
        this.passportId = passportId;
        this.credit = credit;
        this.address = address;
        this.job = job;
        this.salary = salary;
        this.status = status;
    }

    public ClientImpl(String name, String passportId, Credit credit, String address, String job, Integer salary) {
        this.name = name;
        this.passportId = passportId;
        this.credit = credit;
        this.address = address;
        this.job = job;
        this.salary = salary;
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
