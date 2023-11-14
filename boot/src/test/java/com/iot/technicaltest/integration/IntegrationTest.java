package com.iot.technicaltest.integration;


import com.iot.technicaltest.BootApplication;
import com.iot.technicaltest.apirest.api.PricesDTO;
import com.iot.technicaltest.apirest.api.PricesResponseDTO;

import com.iot.technicaltest.application.exceptions.PriceNotFoundException;
import com.iot.technicaltest.config.ContainersEnviorment;
import com.iot.technicaltest.sqlrepository.PricesRepository;
import com.iot.technicaltest.utils.IntegrationTestUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest extends ContainersEnviorment {

    @Autowired
    private PricesRepository pricesRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void init(){
        pricesRepository.save(IntegrationTestUtils.pricesEntityOne);
        pricesRepository.save(IntegrationTestUtils.pricesEntityTwo);
        pricesRepository.save(IntegrationTestUtils.pricesEntityThree);
        pricesRepository.save(IntegrationTestUtils.pricesEntityFour);
    }

    @Test
    @SneakyThrows
    @DisplayName("Test insert price")
    void testCreatePrice() {
        HttpEntity<PricesDTO> requestEntity = new HttpEntity<>(IntegrationTestUtils.pricesDTO);
        var res = restTemplate.exchange(
                IntegrationTestUtils.DEFAULT_URL,
                HttpMethod.POST,
                requestEntity,
                PricesDTO.class
        );
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(IntegrationTestUtils.pricesDTOResponse,res.getBody());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test create price required argument")
    void testCreatePriceRequiredArgument() {
        HttpEntity<PricesDTO> requestEntity = new HttpEntity<>(IntegrationTestUtils.getPricesDTOIncomplete);
        var res = restTemplate.exchange(
                IntegrationTestUtils.DEFAULT_URL,
                HttpMethod.POST,
                requestEntity,
                PricesDTO.class
        );
        assertEquals(HttpStatus.BAD_REQUEST,res.getStatusCode());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test get Prices Nm One")
    void testGetPricesOne(){
        var res = restTemplate.exchange(
                IntegrationTestUtils.URL_GET_TEST_OK_1,
                HttpMethod.GET,
                null,
                PricesResponseDTO.class
        );
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(IntegrationTestUtils.getPricesResponseOne,res.getBody());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test get Prices Nm Two")
    void testGetPricesTwo(){
        var res = restTemplate.exchange(
                IntegrationTestUtils.URL_GET_TEST_OK_2,
                HttpMethod.GET,
                null,
                PricesResponseDTO.class
        );
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(IntegrationTestUtils.getPricesResponseTwo,res.getBody());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test get Prices Nm Three")
    void testGetPricesThree(){
        var res = restTemplate.exchange(
                IntegrationTestUtils.URL_GET_TEST_OK_3,
                HttpMethod.GET,
                null,
                PricesResponseDTO.class
        );
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(IntegrationTestUtils.getPricesResponseOne,res.getBody());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test get Prices Nm Four")
    void testGetPricesFour(){
        var res = restTemplate.exchange(
                IntegrationTestUtils.URL_GET_TEST_OK_4,
                HttpMethod.GET,
                null,
                PricesResponseDTO.class
        );
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(IntegrationTestUtils.getPricesResponseThree,res.getBody());
    }

    @Test
    @SneakyThrows
    @DisplayName("Test get Prices Nm Five")
    void testGetPricesFive(){
        var res = restTemplate.exchange(
                IntegrationTestUtils.URL_GET_TEST_OK_5,
                HttpMethod.GET,
                null,
                PricesResponseDTO.class
        );
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(IntegrationTestUtils.getPricesResponseFour,res.getBody());
    }
    @Test
    @SneakyThrows
    @DisplayName("Test throw PriceNotFoundException")
    void testThrowPNF(){
        var res = restTemplate.exchange(
                IntegrationTestUtils.URL_GET_TEST_EXCEPTION,
                HttpMethod.GET,
                null,
                PriceNotFoundException.class
        );
        assertEquals(HttpStatus.NOT_FOUND,res.getStatusCode());
    }


}
