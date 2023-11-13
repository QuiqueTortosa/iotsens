package com.iot.technicaltest.apirest.mappers;

import com.iot.technicaltest.apirest.api.PricesResponseDTO;
import com.iot.technicaltest.application.domain.Prices;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesResponseDTOMapper {

    Prices toDomain(PricesResponseDTO pricesDTO);
    PricesResponseDTO fromDomain(Prices prices);

}
