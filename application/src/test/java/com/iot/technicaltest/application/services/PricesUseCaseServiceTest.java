package com.iot.technicaltest.application.services;

import com.iot.technicaltest.application.domain.Prices;
import com.iot.technicaltest.application.exceptions.PriceNotFoundException;
import com.iot.technicaltest.application.ports.driven.PricesRepositoryPort;
import com.iot.technicaltest.application.utils.PricesServiceUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class PricesUseCaseServiceTest {

    @Mock
    private PricesRepositoryPort repositoryPort;
    private PricesUseCaseService useCaseService;

    @BeforeEach
    void init(){
        useCaseService = new PricesUseCaseService(repositoryPort);
    }

    @Test
    @SneakyThrows
    @DisplayName("Test getPrice of List")
    void testGetPrice(){

        given(repositoryPort.findPrices(any(Long.class),any(Long.class),any(LocalDateTime.class)))
                .willReturn(PricesServiceUtils.getPriceList());

        var result = useCaseService.getPrice(PricesServiceUtils.PRODUCT_ID_TEST,PricesServiceUtils.BRAND_TEST,PricesServiceUtils.DATE_TEST);

        assertEquals(result.getProductId(), PricesServiceUtils.getPriceList().get(1).getProductId());
        assertEquals(result.getBrandId(), PricesServiceUtils.getPriceList().get(1).getBrandId());
        assertEquals(result.getPriceList(), PricesServiceUtils.getPriceList().get(1).getPriceList());
        assertEquals(result.getStartDate(), PricesServiceUtils.getPriceList().get(1).getStartDate());
        assertEquals(result.getEndDate(), PricesServiceUtils.getPriceList().get(1).getEndDate());
        assertEquals(result.getPrice(), PricesServiceUtils.getPriceList().get(1).getPrice());
        assertEquals(result.getCurr(), PricesServiceUtils.getPriceList().get(1).getCurr());
        assertEquals(result.getPriority(), PricesServiceUtils.getPriceList().get(1).getPriority());

        assertNotNull(result);

    }

    @Test
    @SneakyThrows
    @DisplayName("Test getPrice throw PriceNotFoundException")
    void testGetPriceThrowPNF(){

        given(repositoryPort.findPrices(any(Long.class),any(Long.class),any(LocalDateTime.class)))
                .willReturn(new ArrayList<>());

        Executable executable = () -> useCaseService.getPrice(PricesServiceUtils.PRODUCT_ID_TEST,
                PricesServiceUtils.BRAND_TEST, PricesServiceUtils.DATE_TEST);

        assertThrows(PriceNotFoundException.class, executable);

    }

    @Test
    @SneakyThrows
    @DisplayName("Test createPrice")
    void testCreatePriceThrowPNF(){

        given(repositoryPort.createPrice(any(Prices.class)))
                .willReturn(PricesServiceUtils.getPrice());

        var result = useCaseService.createPrice(PricesServiceUtils.getPrice());

        assertEquals(result.getProductId(), PricesServiceUtils.getPrice().getProductId());
        assertEquals(result.getBrandId(), PricesServiceUtils.getPrice().getBrandId());
        assertEquals(result.getPriceList(), PricesServiceUtils.getPrice().getPriceList());
        assertEquals(result.getStartDate(), PricesServiceUtils.getPrice().getStartDate());
        assertEquals(result.getEndDate(), PricesServiceUtils.getPrice().getEndDate());
        assertEquals(result.getPrice(), PricesServiceUtils.getPrice().getPrice());
        assertEquals(result.getCurr(), PricesServiceUtils.getPrice().getCurr());
        assertEquals(result.getPriority(), PricesServiceUtils.getPrice().getPriority());

        assertNotNull(result);
    }



}
