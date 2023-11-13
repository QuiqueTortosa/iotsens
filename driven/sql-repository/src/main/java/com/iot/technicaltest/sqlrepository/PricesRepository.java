package com.iot.technicaltest.sqlrepository;

import com.iot.technicaltest.sqlrepository.entities.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

public interface PricesRepository extends CrudRepository<PricesEntity, Long> {

    @Query("SELECT p FROM PricesEntity p WHERE p.productId = :productId  AND p.brandId = :brandId AND p.startDate <= :date AND p.endDate >= :date")
    List<PricesEntity> findPrices(@Param("productId")Long productId, @Param("brandId")Long brandId, @Param("date")LocalDateTime date);

}
