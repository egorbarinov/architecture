package com.egorbarinov.securemodule.dto;

import com.egorbarinov.securemodule.entities.ClientStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {

    private Long id;
    private String name;
    private String passportId;
    private String address;
    private String job;
    private Integer salary;
    private ClientStatus status;
    private boolean isResident;
    private boolean isCheckForDebts;
    private boolean checkNDFL;
    private boolean isNotCriminal;

    @Override
    public String toString() {
        return "ClientDto{" +
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
