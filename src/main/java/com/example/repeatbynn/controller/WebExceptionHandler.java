package com.example.repeatbynn.controller;

import com.example.repeatbynn.dto.common.CommonMessage;
import com.example.repeatbynn.dto.common.CommonResponse;
import com.example.repeatbynn.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebExceptionHandler {
    @ExceptionHandler(BaseException.class)
    private ResponseEntity<CommonResponse> handle(BaseException exception) {
        CommonResponse response = new CommonResponse();
        response.setStatus("Failed");
        CommonMessage message = new CommonMessage();
        message.setMessage(exception.getMessage());
        message.setCode(exception.getCode());
        message.setDescription(exception.getDescription());
        response.setMessage(message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
