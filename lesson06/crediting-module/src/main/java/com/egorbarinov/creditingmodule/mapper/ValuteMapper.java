package com.egorbarinov.creditingmodule.mapper;

import com.egorbarinov.creditingmodule.dto.ValuteDto;
import com.egorbarinov.creditingmodule.entities.Valute;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface ValuteMapper {
    ValuteMapper MAPPER = Mappers.getMapper(ValuteMapper.class);

    Valute toValute(ValuteDto dto);

    @InheritInverseConfiguration
    ValuteDto fromValute(Valute valute);

    List<Valute> toValuteList(List<ValuteDto> valuteDtos);

    List<ValuteDto> fromValuteList(Collection<Valute> valutes);

}
