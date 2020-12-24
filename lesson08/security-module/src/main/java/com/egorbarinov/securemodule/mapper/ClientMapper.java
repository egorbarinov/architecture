package com.egorbarinov.securemodule.mapper;

import com.egorbarinov.securemodule.dto.ClientDto;
import com.egorbarinov.securemodule.entities.ClientImpl;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

//@Mapper(componentModel = "spring")
@Mapper
public interface ClientMapper {

    ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);

    ClientImpl toClientImpl(ClientDto clientDto);

    @InheritInverseConfiguration
    ClientDto fromClientImpl(ClientImpl clientImpl);

    List<ClientImpl> toClientList(List<ClientDto> clientDtos);

    List<ClientDto> fromClientList(Collection<ClientImpl> clients);
}
