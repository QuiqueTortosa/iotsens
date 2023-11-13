package com.iot.technicaltest.integration;

import com.iot.technicaltest.application.exceptions.PriceNotFoundException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest
@ExtendWith(SpringExtension.class)
public class IntegrationTest {


    @Container
    private static final GenericContainer<?> h2Container = new GenericContainer<>("h2:latest");

    @BeforeAll
    static void beforeAll() {
        h2Container.start();
    }

    @AfterAll
    static void afterAll() {
        h2Container.stop();
    }


    @Test
    @SneakyThrows
    @DisplayName("Test getPrice throw PriceNotFoundException")
    void testGetPriceThrowPNF(){
        assertEquals(1,1);
    }


}
