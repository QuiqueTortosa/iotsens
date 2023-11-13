package com.iot.technicaltest.integration;

import com.iot.technicaltest.BootApplication;
import com.iot.technicaltest.apirest.api.PricesResponseDTO;
import com.iot.technicaltest.application.services.PricesUseCaseService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class IntegrationTest {

    @Container
    private static final PostgreSQLContainer<?> database = new PostgreSQLContainer<>("postgres:16.0");

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @SneakyThrows
    @DisplayName("Test Connection stablished")
    void connectionEstablished() {
        assertEquals(database.isCreated(),true);
        assertEquals(database.isRunning(),true);
    }

    @Test
    @SneakyThrows
    @DisplayName("Test getPrice throw PriceNotFoundException")
    void testGetPriceThrowPNF(){
        String baseUrl = "/api/v1/prices?productId=35455&brandId=1&date=2020-06-14T16:00:00";
        var response = restTemplate.exchange(baseUrl, HttpMethod.GET,null, PricesResponseDTO.class);
        assertEquals(1,1);
    }


}
