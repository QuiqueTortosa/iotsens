package com.iot.technicaltest.sqlrepository.mappers;

import com.iot.technicaltest.sqlrepository.utils.PricesRepositoryUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
public class PricesMapperTest {

    private PricesMapper pricesMapper;

    @BeforeEach
    void init(){
        pricesMapper = new PricesMapperImpl();
    }

    @Test
    @DisplayName("Test PricesMapper to domain")
    void testMapToDomain(){
        var expected = PricesRepositoryUtils.getPrice();

        var res = pricesMapper.toDomain(PricesRepositoryUtils.getPriceEntity());

        assertEquals(expected.getBrandId(), res.getBrandId());
        assertEquals(expected.getStartDate(), res.getStartDate());
        assertEquals(expected.getEndDate(), res.getEndDate());
        assertEquals(expected.getPriceList(), res.getPriceList());
        assertEquals(expected.getProductId(), res.getProductId());
        assertEquals(expected.getPrice(), res.getPrice());
        assertNull(pricesMapper.fromDomain(null));
    }

    @Test
    @DisplayName("Test PricesMapper from domain")
    void testMapFromDomain(){
        var expected = PricesRepositoryUtils.getPriceEntity();
        var res = pricesMapper.fromDomain(PricesRepositoryUtils.getPrice());

        assertEquals(expected.getBrandId(), res.getBrandId());
        assertEquals(expected.getStartDate(), res.getStartDate());
        assertEquals(expected.getEndDate(), res.getEndDate());
        assertEquals(expected.getPriceList(), res.getPriceList());
        assertEquals(expected.getProductId(), res.getProductId());
        assertEquals(expected.getPrice(), res.getPrice());
        assertNull(pricesMapper.fromDomain(null));
    }

    @Test
    @DisplayName("Test PricesMapper to domain list")
    void testMapToDomainList(){
        var expected = PricesRepositoryUtils.getPriceList();
        var res = pricesMapper.toDomainList(PricesRepositoryUtils.getPriceEntityList());

        assertEquals(expected.size(), res.size());

        assertNull(pricesMapper.toDomainList(null));
    }

}
