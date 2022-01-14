package com.example.repeatbynn.exception;

public class NotFoundException extends BaseException {

    public NotFoundException(BusinessExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage(), exceptionEnum.getCode(), exceptionEnum.getDescription());
    }

    public NotFoundException(BusinessExceptionEnum exceptionEnum, Object object) {
        super(String.format(exceptionEnum.getMessage(), object), exceptionEnum.getCode(), exceptionEnum.getDescription());
    }
}
