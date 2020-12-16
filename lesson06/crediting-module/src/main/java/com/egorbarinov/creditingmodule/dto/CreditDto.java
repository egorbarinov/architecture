package com.egorbarinov.creditingmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditDto {
    private Double amount;
    private Double percentage;
    private Integer creditPeriod;
}
