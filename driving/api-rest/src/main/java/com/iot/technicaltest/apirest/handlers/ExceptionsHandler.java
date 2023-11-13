package com.iot.technicaltest.apirest.handlers;

import com.iot.technicaltest.apirest.api.ErrorResponseDTO;
import com.iot.technicaltest.application.exceptions.PriceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionsHandler {

    @ExceptionHandler({PriceNotFoundException.class})
    public ResponseEntity<ErrorResponseDTO> handlePriceNotFoundException(PriceNotFoundException priceNotFoundException){
        var errorResponse = new ErrorResponseDTO()
                .code(priceNotFoundException.getErrorCode())
                .description(priceNotFoundException.getMessage());
        log.error("Price not found exception: ", priceNotFoundException);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
