package com.iot.technicaltest.sqlrepository.mappers;

import com.iot.technicaltest.application.domain.Prices;
import com.iot.technicaltest.sqlrepository.entities.PricesEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PricesMapper {

        Prices toDomain(PricesEntity pricesEntity);
        PricesEntity fromDomain(Prices prices);
        List<Prices> toDomainList(List<PricesEntity> pricesEntities);

}
