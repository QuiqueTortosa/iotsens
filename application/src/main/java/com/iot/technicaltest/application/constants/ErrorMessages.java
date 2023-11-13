package com.iot.technicaltest.application.constants;

public enum ErrorMessages {

    PRICE_NOT_FOUND("Price not found");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
