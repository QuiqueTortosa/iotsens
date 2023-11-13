package com.iot.technicaltest.application.services;


import com.iot.technicaltest.application.constants.ErrorCodes;
import com.iot.technicaltest.application.constants.ErrorMessages;
import com.iot.technicaltest.application.domain.Prices;
import com.iot.technicaltest.application.exceptions.PriceNotFoundException;
import com.iot.technicaltest.application.ports.driven.PricesRepositoryPort;
import com.iot.technicaltest.application.ports.driving.PricesServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PricesUseCaseService implements PricesServicePort {

    private final PricesRepositoryPort repository;

    @Override
    public Prices getPrice(Long productId, Long brandId, LocalDateTime date) {
        var priceList = repository.findPrices(productId,brandId,date);
        return priceList.stream()
                .max(Comparator.comparing(Prices::getPriority))
                .orElseThrow(() -> new PriceNotFoundException(ErrorMessages.PRICE_NOT_FOUND.getMessage(), ErrorCodes.PNF.name()));
    }

    @Override
    public Prices createPrice(Prices prices) {
        return repository.createPrice(prices);
    }
}
