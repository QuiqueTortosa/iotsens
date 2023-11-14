package com.iot.technicaltest.apirest.utils;

import com.iot.technicaltest.apirest.api.PricesDTO;
import com.iot.technicaltest.apirest.api.PricesResponseDTO;
import com.iot.technicaltest.application.domain.Prices;

import java.time.LocalDateTime;

public class PricesApiUtils {

    public final static Long BRAND_TEST = 1L;
    public final static Long PRODUCT_ID_TEST = 35455L;
    public final static LocalDateTime DATE_TEST_OK_1 = LocalDateTime.of(2020,6,14,10,0);
    public final static LocalDateTime DATE_TEST_OK_2 = LocalDateTime.of(2020,6,14,16,0);
    public final static LocalDateTime DATE_TEST_OK_3 = LocalDateTime.of(2020,6,14,21,0);
    public final static LocalDateTime DATE_TEST_OK_4 = LocalDateTime.of(2020,6,15,10,0);
    public final static LocalDateTime DATE_TEST_OK_5 = LocalDateTime.of(2020,6,16,21,0);
    public final static LocalDateTime DATE_TEST_EXCEPTION = LocalDateTime.of(2018,6,16,21,0);

    public static Prices getPricesRecordOne(){
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
    public static Prices getPricesRecordTwo(){
        return Prices.builder()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020,6,14,15,0,0))
                .endDate(LocalDateTime.of(2020,6,14,18,30,0))
                .priceList(2)
                .productId(35455L)
                .priority(1L)
                .price(25.45)
                .curr("EUR")
                .build();
    }

    public static Prices getPricesRecordThree(){
        return Prices.builder()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020,6,15,0,0,0))
                .endDate(LocalDateTime.of(2020,12,15,11,0,0))
                .priceList(3)
                .productId(35455L)
                .priority(1L)
                .price(30.50)
                .curr("EUR")
                .build();
    }

    public static Prices getPricesRecordFour(){
        return Prices.builder()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020,6,15,16,0,0))
                .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                .priceList(4)
                .productId(35455L)
                .priority(1L)
                .price(38.95)
                .curr("EUR")
                .build();
    }

    public static PricesResponseDTO getPricesResponseOne(){
        return new PricesResponseDTO()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020,6,14,0,0,0))
                .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                .priceList(1)
                .productId(35455L)
                .price(35.50)
                .curr("EUR");
    }
    public static PricesResponseDTO getPricesResponseTwo(){
        return new PricesResponseDTO()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020,6,14,15,0,0))
                .endDate(LocalDateTime.of(2020,6,14,18,30,0))
                .priceList(2)
                .productId(35455L)
                .price(25.45)
                .curr("EUR");
    }

    public static PricesResponseDTO getPricesResponseThree(){
        return new PricesResponseDTO()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020,6,15,0,0,0))
                .endDate(LocalDateTime.of(2020,6,15,11,0,0))
                .priceList(3)
                .productId(35455L)
                .price(30.50)
                .curr("EUR");
    }

    public static PricesResponseDTO getPricesResponseFour(){
        return new PricesResponseDTO()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020,6,15,16,0,0))
                .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                .priceList(4)
                .productId(35455L)
                .price(38.95)
                .curr("EUR");
    }

    public static PricesDTO getPricesDTO(){
        return new PricesDTO()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020,6,14,0,0,0))
                .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                .priceList(1)
                .productId(35455L)
                .price(35.50)
                .curr("EUR")
                .priority(0L);
    }

    public static PricesDTO getPricesDTOIncomplete(){
        return new PricesDTO()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020,6,14,0,0,0))
                .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                .priceList(1)
                .productId(35455L)
                .price(35.50)
                .priority(0L);
    }

}
