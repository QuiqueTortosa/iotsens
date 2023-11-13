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
public class PricesResponseDTOMapperTest {

    private PricesResponseDTOMapper pricesResponseDTOMapper;

    @BeforeEach
    void init() {
        pricesResponseDTOMapper = new PricesResponseDTOMapperImpl();
    }

    @Test
    @DisplayName("Test PricesResponseDTOMapper to domain")
    void testMapToDomain(){
        var expected = PricesApiUtils.getPricesRecordOne();

        var res = pricesResponseDTOMapper.toDomain(PricesApiUtils.getPricesResponseOne());

        assertEquals(expected.getBrandId(), res.getBrandId());
        assertEquals(expected.getStartDate(), res.getStartDate());
        assertEquals(expected.getEndDate(), res.getEndDate());
        assertEquals(expected.getPriceList(), res.getPriceList());
        assertEquals(expected.getProductId(), res.getProductId());
        assertEquals(expected.getPrice(), res.getPrice());
        assertNull(pricesResponseDTOMapper.toDomain(null));
    }

    @Test
    @DisplayName("Test PricesResponseDTOMapper from domain")
    void testMapFromDomain(){
        var expected = PricesApiUtils.getPricesResponseOne();

        var res = pricesResponseDTOMapper.fromDomain(PricesApiUtils.getPricesRecordOne());

        assertEquals(expected.getBrandId(), res.getBrandId());
        assertEquals(expected.getStartDate(), res.getStartDate());
        assertEquals(expected.getEndDate(), res.getEndDate());
        assertEquals(expected.getPriceList(), res.getPriceList());
        assertEquals(expected.getProductId(), res.getProductId());
        assertEquals(expected.getPrice(), res.getPrice());
        assertNull(pricesResponseDTOMapper.fromDomain(null));
    }


}
