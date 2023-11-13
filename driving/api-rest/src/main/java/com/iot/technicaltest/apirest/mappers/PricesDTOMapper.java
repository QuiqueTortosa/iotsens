package com.iot.technicaltest.apirest.mappers;

import com.iot.technicaltest.apirest.api.PricesDTO;
import com.iot.technicaltest.application.domain.Prices;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesDTOMapper {

    Prices toDomain(PricesDTO pricesDTO);
    PricesDTO fromDomain(Prices prices);

}
