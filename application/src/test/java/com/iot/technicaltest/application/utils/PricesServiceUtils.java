package com.iot.technicaltest.application.utils;

import com.iot.technicaltest.application.domain.Prices;

import java.time.LocalDateTime;
import java.util.List;

public class PricesServiceUtils {

    public final static Long BRAND_TEST = 1L;
    public final static Long PRODUCT_ID_TEST = 35455L;
    public final static LocalDateTime DATE_TEST = LocalDateTime.of(2020,6,14,16,0);

    public static Prices getPrice(){
        return Prices.builder()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020,6,14,0,0,0))
                .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                .priceList(1)
                .productId(35455L)
                .priority(0L)
                .price(35.50)
                .curr("EUR")
                .build();
    }
    public static List<Prices> getPriceList() {
        return List.of(
                Prices.builder()
                        .brandId(1L)
                        .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                        .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                        .priceList(1)
                        .productId(35455L)
                        .priority(0L)
                        .price(35.50)
                        .curr("EUR")
                        .build(),
                Prices.builder()
                        .brandId(1L)
                        .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
                        .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
                        .priceList(2)
                        .productId(35455L)
                        .priority(1L)
                        .price(25.45)
                        .curr("EUR")
                        .build()
        );
    }
}
