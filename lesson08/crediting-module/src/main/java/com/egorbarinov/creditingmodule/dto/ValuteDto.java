package com.egorbarinov.creditingmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValuteDto {

    private Long pk;
    private String id;
    private String numCode;
    private String charCode;
    private BigDecimal nominal;
    private String name;
    private BigDecimal value;
    private String currencyFrom;
    private String currencyTo;

    @NotNull
    @DecimalMin("0.0")
    @Digits(integer = 11, fraction = 2)
    private BigDecimal amountToConvert;

    private BigDecimal convertedAmount;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date conversionDate;

    public void setValue(String value) {
        this.value = new BigDecimal(value.replaceAll(",", "\\."));
    }

}
