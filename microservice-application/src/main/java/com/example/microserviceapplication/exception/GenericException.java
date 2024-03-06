package com.example.microserviceapplication.exception;

import lombok.Getter;

@Getter
public class GenericException extends RuntimeException {

    private final String code;
    private final String message;
    private final int status;

    public GenericException(String code, String message, int status) {
        super(message);
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
