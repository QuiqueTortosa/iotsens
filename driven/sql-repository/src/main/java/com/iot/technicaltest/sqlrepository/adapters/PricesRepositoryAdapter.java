package com.iot.technicaltest.sqlrepository.adapters;

import com.iot.technicaltest.application.domain.Prices;
import com.iot.technicaltest.application.ports.driven.PricesRepositoryPort;
import com.iot.technicaltest.sqlrepository.PricesRepository;
import com.iot.technicaltest.sqlrepository.mappers.PricesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PricesRepositoryAdapter implements PricesRepositoryPort {

    private final PricesRepository repository;
    private final PricesMapper mapper;

    @Override
    public List<Prices> findPrices(Long productId, Long brandId, LocalDateTime date) {
        var prices = repository.findPrices(productId, brandId, date);
        return mapper.toDomainList(prices);
    }

    @Override
    public Prices createPrice(Prices prices) {
        var savePrice = repository.save(mapper.fromDomain(prices));
        return mapper.toDomain(savePrice);
    }
}
