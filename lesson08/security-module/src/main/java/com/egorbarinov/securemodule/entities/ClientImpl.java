package com.egorbarinov.securemodule.entities;


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
@Table(schema = "banking_structure", name = "result_verification")
public class ClientImpl implements Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private String name;
    @Column
    private String passportId;
//    @OneToOne(targetEntity = ConsumerLoan.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id")
//    private ConsumerLoan credit;
    @Column
    private String address;
    @Column
    private String job;
    @Column
    private Integer salary;
    @Enumerated(EnumType.STRING)
    private ClientStatus status;
    @Column
    private boolean isResident;
    @Column
    private boolean isCheckForDebts;
    @Column
    private boolean checkNDFL;
    @Column
    private boolean isNotCriminal;


    @Override
    public String getInfo() {
        return "ClientImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passportId='" + passportId + '\'' +
//                ", credit=" + credit +
                '}';
    }

    @Override
    public String toString() {
        return "ClientImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passportId='" + passportId + '\'' +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", status=" + status +
                ", isResident=" + isResident +
                ", isCheckForDebts=" + isCheckForDebts +
                ", checkNDFL=" + checkNDFL +
                ", isNotCriminal=" + isNotCriminal +
                '}';
    }
}
