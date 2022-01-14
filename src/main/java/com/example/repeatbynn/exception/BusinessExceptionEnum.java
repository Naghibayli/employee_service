package com.example.repeatbynn.exception;

public enum BusinessExceptionEnum {

    EMPLOYEE_BY_ID_NOT_FOUND("Employee %s not found", "44544", "Not in DB");

    private String message;
    private String code;
    private String description;

    BusinessExceptionEnum(String message, String code, String description) {
        this.message = message;
        this.code = code;
        this.description = description;
    }

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
