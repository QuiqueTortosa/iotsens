package com.iot.technicaltest.application.exceptions;

import lombok.Getter;

@Getter
public class PriceNotFoundException extends RuntimeException{

    private final String errorCode;

    public PriceNotFoundException(String msg, String errorCode){
        super(msg);
        this.errorCode = errorCode;
    }

}
