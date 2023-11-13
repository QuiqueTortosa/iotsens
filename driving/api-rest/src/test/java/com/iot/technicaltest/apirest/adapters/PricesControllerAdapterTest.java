package com.iot.technicaltest.apirest.adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot.technicaltest.apirest.api.PricesDTO;
import com.iot.technicaltest.apirest.controllers.PricesControllerAdapter;
import com.iot.technicaltest.apirest.handlers.ExceptionsHandler;
import com.iot.technicaltest.apirest.mappers.PricesDTOMapper;
import com.iot.technicaltest.apirest.mappers.PricesResponseDTOMapper;
import com.iot.technicaltest.apirest.utils.PricesApiUtils;
import com.iot.technicaltest.application.constants.ErrorCodes;
import com.iot.technicaltest.application.constants.ErrorMessages;
import com.iot.technicaltest.application.domain.Prices;
import com.iot.technicaltest.application.exceptions.PriceNotFoundException;
import com.iot.technicaltest.application.ports.driving.PricesServicePort;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Import({ExceptionsHandler.class})
@ContextConfiguration(classes = PricesControllerAdapter.class)
public class PricesControllerAdapterTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private PricesDTOMapper pricesDTOMapper;
    @MockBean
    private PricesResponseDTOMapper pricesResponseDTOMapper;
    @MockBean
    private PricesServicePort service;

    @Test
    @SneakyThrows
    @DisplayName("Test get Prices 1")
    void testGetPrices1(){
        given(service.getPrice(any(Long.class),any(Long.class),any(LocalDateTime.class)))
                .willReturn(PricesApiUtils.getPricesRecordOne());
        given(pricesResponseDTOMapper.fromDomain(any(Prices.class))).willReturn(PricesApiUtils.getPricesResponseOne());
        mockMvc.perform(get("/api/v1/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("date", String.valueOf(PricesApiUtils.DATE_TEST_OK_1))
                        .param("productId", String.valueOf(PricesApiUtils.PRODUCT_ID_TEST))
                        .param("brandId", String.valueOf(PricesApiUtils.BRAND_TEST))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andReturn();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test get Prices 2")
    void testGetPrices2(){
        given(service.getPrice(any(Long.class),any(Long.class),any(LocalDateTime.class)))
                .willReturn(PricesApiUtils.getPricesRecordTwo());
        given(pricesResponseDTOMapper.fromDomain(any(Prices.class))).willReturn(PricesApiUtils.getPricesResponseTwo());
        mockMvc.perform(get("/api/v1/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("date", String.valueOf(PricesApiUtils.DATE_TEST_OK_2))
                        .param("productId", String.valueOf(PricesApiUtils.PRODUCT_ID_TEST))
                        .param("brandId", String.valueOf(PricesApiUtils.BRAND_TEST))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00"))
                .andReturn();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test get Prices 3")
    void testGetPrices3(){
        given(service.getPrice(any(Long.class),any(Long.class),any(LocalDateTime.class)))
                .willReturn(PricesApiUtils.getPricesRecordOne());
        given(pricesResponseDTOMapper.fromDomain(any(Prices.class))).willReturn(PricesApiUtils.getPricesResponseOne());
        mockMvc.perform(get("/api/v1/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("date", String.valueOf(PricesApiUtils.DATE_TEST_OK_3))
                        .param("productId", String.valueOf(PricesApiUtils.PRODUCT_ID_TEST))
                        .param("brandId", String.valueOf(PricesApiUtils.BRAND_TEST))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andReturn();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test get Prices 4")
    void testGetPrices4(){
        given(service.getPrice(any(Long.class),any(Long.class),any(LocalDateTime.class)))
                .willReturn(PricesApiUtils.getPricesRecordThree());
        given(pricesResponseDTOMapper.fromDomain(any(Prices.class))).willReturn(PricesApiUtils.getPricesResponseThree());
        mockMvc.perform(get("/api/v1/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("date", String.valueOf(PricesApiUtils.DATE_TEST_OK_4))
                        .param("productId", String.valueOf(PricesApiUtils.PRODUCT_ID_TEST))
                        .param("brandId", String.valueOf(PricesApiUtils.BRAND_TEST))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.5))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00"))
                .andReturn();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test get Prices 5")
    void testGetPrices5(){
        given(service.getPrice(any(Long.class),any(Long.class),any(LocalDateTime.class)))
                .willReturn(PricesApiUtils.getPricesRecordFour());
        given(pricesResponseDTOMapper.fromDomain(any(Prices.class))).willReturn(PricesApiUtils.getPricesResponseFour());
        mockMvc.perform(get("/api/v1/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("date", String.valueOf(PricesApiUtils.DATE_TEST_OK_5))
                        .param("productId", String.valueOf(PricesApiUtils.PRODUCT_ID_TEST))
                        .param("brandId", String.valueOf(PricesApiUtils.BRAND_TEST))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andReturn();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test ThrowPricesNotFound")
    void testThrowPricesNotFound(){
        given(service.getPrice(any(Long.class),any(Long.class),any(LocalDateTime.class)))
                .willThrow(new PriceNotFoundException(ErrorMessages.PRICE_NOT_FOUND.getMessage(), ErrorCodes.PNF.name()));
        mockMvc.perform(get("/api/v1/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("date", String.valueOf(PricesApiUtils.DATE_TEST_EXCEPTION))
                        .param("productId", String.valueOf(PricesApiUtils.PRODUCT_ID_TEST))
                        .param("brandId", String.valueOf(PricesApiUtils.BRAND_TEST))
                )
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.code", is(ErrorCodes.PNF.name())))
                .andExpect(jsonPath("$.description", is(ErrorMessages.PRICE_NOT_FOUND.getMessage())))
                .andReturn();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test create prices")
    void testCreatePrices(){
        String pricesDTOJson = objectMapper.writeValueAsString(PricesApiUtils.getPricesDTO());

        given(service.createPrice(any(Prices.class)))
                .willReturn(PricesApiUtils.getPricesRecordOne());
        given(pricesDTOMapper.toDomain(any(PricesDTO.class)))
                .willReturn(PricesApiUtils.getPricesRecordOne());
        given(pricesDTOMapper.fromDomain(any(Prices.class)))
                .willReturn(PricesApiUtils.getPricesDTO());

        mockMvc.perform(post("/api/v1/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pricesDTOJson)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.curr").value("EUR"))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.priority").value(0))
                .andReturn();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test create prices required argument")
    void testCreatePricesError(){
        String pricesDTOJson = objectMapper.writeValueAsString(PricesApiUtils.getPricesDTOIncomplete());

        given(service.createPrice(any(Prices.class)))
                .willReturn(PricesApiUtils.getPricesRecordOne());
        given(pricesDTOMapper.toDomain(any(PricesDTO.class)))
                .willReturn(PricesApiUtils.getPricesRecordOne());
        given(pricesDTOMapper.fromDomain(any(Prices.class)))
                .willReturn(PricesApiUtils.getPricesDTOIncomplete());

        mockMvc.perform(post("/api/v1/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pricesDTOJson)
                )
                .andExpect(status().is4xxClientError())
                .andReturn();
    }


}
