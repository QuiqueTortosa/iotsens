package com.iot.technicaltest.application.ports.driving;

import com.iot.technicaltest.application.domain.Prices;

import java.time.LocalDateTime;

public interface PricesServicePort {

    Prices getPrice (Long productId, Long brandId, LocalDateTime date);

    Prices createPrice (Prices prices);
}
