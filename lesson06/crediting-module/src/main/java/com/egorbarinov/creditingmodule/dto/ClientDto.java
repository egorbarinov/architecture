package com.egorbarinov.creditingmodule.dto;

import com.egorbarinov.creditingmodule.entities.ClientStatus;
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
    private boolean isCheckNDFL;
    private boolean isNotCriminal;


}
