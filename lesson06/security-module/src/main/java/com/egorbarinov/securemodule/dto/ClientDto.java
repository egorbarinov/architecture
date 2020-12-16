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
    private boolean isResident = false;
    private boolean isCheckForDebts = false;
    private boolean checkNDFL = false;
    private boolean isNotCriminal = false;


}
