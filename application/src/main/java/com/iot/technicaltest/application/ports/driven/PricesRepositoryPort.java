package com.iot.technicaltest.application.ports.driven;

import com.iot.technicaltest.application.domain.Prices;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PricesRepositoryPort {

    List<Prices> findPrices(Long productId, Long brandId, LocalDateTime date);

    Prices createPrice(Prices prices);

}
