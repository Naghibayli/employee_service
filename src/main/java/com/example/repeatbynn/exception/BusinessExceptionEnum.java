package com.example.repeatbynn.exception;

public enum BusinessExceptionEnum {

    EMPLOYEE_BY_ID_NOT_FOUND("Employee %s not found", "404", "Not in DB"),
    DEPARTMENT_BY_ID_NOT_FOUND("Department %s not found", "404", "Not in DB"),
    ADDRESS_NOT_FOUND("Address %s not found", "404", "Not in DB");

    private final String message;
    private final String code;
    private final String description;

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
