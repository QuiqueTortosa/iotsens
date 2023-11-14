package com.iot.technicaltest.utils;

import com.iot.technicaltest.apirest.api.PricesDTO;
import com.iot.technicaltest.apirest.api.PricesResponseDTO;
import com.iot.technicaltest.application.domain.Prices;
import com.iot.technicaltest.sqlrepository.entities.PricesEntity;

import java.time.LocalDateTime;

public class IntegrationTestUtils {

    public final static String DEFAULT_URL = "/api/v1/prices";
    public final static String URL_GET_TEST_OK_1 = DEFAULT_URL + "?productId=35455&brandId=1&date=2020-06-14T10:00:00";
    public final static String URL_GET_TEST_OK_2 = DEFAULT_URL + "?productId=35455&brandId=1&date=2020-06-14T16:00:00";
    public final static String URL_GET_TEST_OK_3 = DEFAULT_URL + "?productId=35455&brandId=1&date=2020-06-14T21:00:00";
    public final static String URL_GET_TEST_OK_4 = DEFAULT_URL + "?productId=35455&brandId=1&date=2020-06-15T10:00:00";
    public final static String URL_GET_TEST_OK_5 = DEFAULT_URL + "?productId=35455&brandId=1&date=2020-06-16T21:00:00";
    public final static String URL_GET_TEST_EXCEPTION = DEFAULT_URL + "?productId=35455&brandId=1&date=2025-06-14T16:00:00";
    public final static PricesEntity pricesEntityOne = PricesEntity.builder()
            .brandId(1L)
            .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .productId(35455L)
            .priority(0L)
            .price(35.50)
            .curr("EUR")
            .build();
    public final static PricesEntity pricesEntityTwo = PricesEntity.builder()
            .brandId(1L)
            .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
            .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
            .productId(35455L)
            .priority(1L)
            .price(25.45)
            .curr("EUR")
            .build();


    public final static PricesEntity pricesEntityThree = PricesEntity.builder()
            .brandId(1L)
            .startDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 6, 15, 11, 0, 0))
            .productId(35455L)
            .priority(1L)
            .price(30.50)
            .curr("EUR")
            .build();

    public final static PricesEntity pricesEntityFour = PricesEntity.builder()
            .brandId(1L)
            .startDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .productId(35455L)
            .priority(1L)
            .price(38.95)
            .curr("EUR")
            .build();

    public final static PricesDTO pricesDTO = new PricesDTO()
            .brandId(2L)
            .startDate(LocalDateTime.of(2023, 11, 14, 0, 0, 0))
            .endDate(LocalDateTime.of(2023, 11, 15, 23, 59, 59))
            .productId(1411L)
            .price(50.50)
            .curr("EUR")
            .priority(2L);

    public final static PricesDTO pricesDTOResponse = new PricesDTO()
            .brandId(2L)
            .startDate(LocalDateTime.of(2023, 11, 14, 0, 0, 0))
            .endDate(LocalDateTime.of(2023, 11, 15, 23, 59, 59))
            .productId(1411L)
            .priceList(5)
            .price(50.50)
            .curr("EUR")
            .priority(2L);

    public final static PricesDTO getPricesDTOIncomplete = new PricesDTO()
                .brandId(1L)
                .startDate(LocalDateTime.of(2023,12,20,10,10,10))
                .endDate(LocalDateTime.of(2023,12,21,20,29,29))
                .priceList(1)
                .productId(35455L)
                .price(35.50)
                .priority(0L);
    public final static Integer priceListInsertFive = 5;

    public final static PricesResponseDTO getPricesResponseOne = new PricesResponseDTO()
            .brandId(1L)
            .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .priceList(1)
            .productId(35455L)
            .price(35.50)
            .curr("EUR");

    public final static PricesResponseDTO getPricesResponseTwo = new PricesResponseDTO()
            .brandId(1L)
            .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
            .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
            .priceList(2)
            .productId(35455L)
            .price(25.45)
            .curr("EUR");

    public final static PricesResponseDTO getPricesResponseThree = new PricesResponseDTO()
            .brandId(1L)
            .startDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 6, 15, 11, 0, 0))
            .priceList(3)
            .productId(35455L)
            .price(30.50)
            .curr("EUR");

    public final static PricesResponseDTO getPricesResponseFour = new PricesResponseDTO()
            .brandId(1L)
            .startDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .priceList(4)
            .productId(35455L)
            .price(38.95)
            .curr("EUR");
}
