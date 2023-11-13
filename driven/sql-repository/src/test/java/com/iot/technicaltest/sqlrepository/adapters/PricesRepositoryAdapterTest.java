package com.iot.technicaltest.sqlrepository.adapters;


import com.iot.technicaltest.application.domain.Prices;
import com.iot.technicaltest.sqlrepository.PricesRepository;
import com.iot.technicaltest.sqlrepository.entities.PricesEntity;
import com.iot.technicaltest.sqlrepository.mappers.PricesMapper;
import com.iot.technicaltest.sqlrepository.utils.PricesRepositoryUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(SpringExtension.class)
public class PricesRepositoryAdapterTest {

    @Mock
    private PricesMapper pricesMapper;
    @Mock
    private PricesRepository pricesRepository;

    private PricesRepositoryAdapter adapter;

    @BeforeEach
    void init(){
        adapter = new PricesRepositoryAdapter(pricesRepository,pricesMapper);
    }

    @Test
    @SneakyThrows
    @DisplayName("Test find prices from repository")
    void testFindPrices(){

        given(pricesRepository.findPrices(any(Long.class),any(Long.class),any(LocalDateTime.class)))
                .willReturn(PricesRepositoryUtils.getPriceEntityList());

        given(pricesMapper.toDomainList(PricesRepositoryUtils.getPriceEntityList()))
                .willReturn(PricesRepositoryUtils.getPriceList());

        var result = adapter.findPrices(
                PricesRepositoryUtils.PRODUCT_ID_TEST,
                PricesRepositoryUtils.BRAND_TEST,
                PricesRepositoryUtils.DATE_TEST
        );
        assertEquals(result.size(),2);
    }

    @Test
    @SneakyThrows
    @DisplayName("Test create price")
    void testCreatePrice(){

        given(pricesRepository.save(any(PricesEntity.class)))
                .willReturn(PricesRepositoryUtils.getPriceEntity());
        given(pricesMapper.fromDomain(any(Prices.class)))
                .willReturn(PricesRepositoryUtils.getPriceEntity());
        given(pricesMapper.toDomain(any(PricesEntity.class)))
                .willReturn(PricesRepositoryUtils.getPrice());

        var result = adapter.createPrice(PricesRepositoryUtils.getPrice());
        assertEquals(result.getPriceList(),1L);
        assertEquals(result.getBrandId(),1L);
        assertEquals(result.getProductId(),35455L);
        assertEquals(result.getStartDate(),LocalDateTime.of(2020,6,14,0,0,0));
        assertEquals(result.getEndDate(),LocalDateTime.of(2020,12,31,23,59,59));
        assertEquals(result.getPrice(),35.50);
        assertEquals(result.getCurr(),"EUR");
        assertEquals(result.getPriority(),0);


    }


}
