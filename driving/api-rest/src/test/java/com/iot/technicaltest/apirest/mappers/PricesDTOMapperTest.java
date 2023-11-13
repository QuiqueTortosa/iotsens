package com.iot.technicaltest.apirest.mappers;

import com.iot.technicaltest.apirest.utils.PricesApiUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
public class PricesDTOMapperTest {

    private PricesDTOMapper pricesDTOMapper;

    @BeforeEach
    void init() {
        pricesDTOMapper = new PricesDTOMapperImpl();
    }

    @Test
    @DisplayName("Test PricesDTOMapper to domain")
    void testMapToDomain(){
        var expected = PricesApiUtils.getPricesRecordOne();

        var res = pricesDTOMapper.toDomain(PricesApiUtils.getPricesDTO());

        assertEquals(expected.getBrandId(), res.getBrandId());
        assertEquals(expected.getStartDate(), res.getStartDate());
        assertEquals(expected.getEndDate(), res.getEndDate());
        assertEquals(expected.getPriceList(), res.getPriceList());
        assertEquals(expected.getProductId(), res.getProductId());
        assertEquals(expected.getPrice(), res.getPrice());
        assertNull(pricesDTOMapper.toDomain(null));
    }

    @Test
    @DisplayName("Test PricesDTOMapper from domain")
    void testMapFromDomain(){
        var expected = PricesApiUtils.getPricesDTO();

        var res = pricesDTOMapper.fromDomain(PricesApiUtils.getPricesRecordOne());

        assertEquals(expected.getBrandId(), res.getBrandId());
        assertEquals(expected.getStartDate(), res.getStartDate());
        assertEquals(expected.getEndDate(), res.getEndDate());
        assertEquals(expected.getPriceList(), res.getPriceList());
        assertEquals(expected.getProductId(), res.getProductId());
        assertEquals(expected.getPrice(), res.getPrice());
        assertNull(pricesDTOMapper.fromDomain(null));
    }

}
