package com.example.repeatbynn.exception;

public class BaseException extends RuntimeException {
    private final String message;
    private final String code;
    private final String description;

    public BaseException(String message, String code, String description) {
        this.message = message;
        this.code = code;
        this.description = description;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
