package com.iot.technicaltest.apirest.controllers;

import com.iot.technicaltest.apirest.api.PricesApi;
import com.iot.technicaltest.apirest.api.PricesDTO;
import com.iot.technicaltest.apirest.api.PricesResponseDTO;
import com.iot.technicaltest.apirest.mappers.PricesDTOMapper;
import com.iot.technicaltest.apirest.mappers.PricesResponseDTOMapper;
import com.iot.technicaltest.application.ports.driving.PricesServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RequestMapping("/api/v1")
@RestController
@Validated
@RequiredArgsConstructor
public class PricesControllerAdapter implements PricesApi {

    private final PricesServicePort pricesService;
    private final PricesDTOMapper pricesDTOMapper;
    private final PricesResponseDTOMapper pricesResponseDTOMapper;

    @Override
    public ResponseEntity<PricesResponseDTO> getPrice(
            @RequestParam Long productId,
            @RequestParam Long brandId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date
    ){
        var prices = pricesService.getPrice(productId,brandId,date);
        return ResponseEntity.ok(pricesResponseDTOMapper.fromDomain(prices));
    }

    @Override
    public ResponseEntity<PricesDTO> createPrice(
            @Valid @RequestBody PricesDTO pricesDTO
    ){
        var prices = pricesService.createPrice(pricesDTOMapper.toDomain(pricesDTO));
        return ResponseEntity.ok(pricesDTOMapper.fromDomain(prices));
    }

}
