package com.example.repeatbynn.dto.common;

import lombok.Data;

@Data
public class CommonResponse {

    private Long time = System.currentTimeMillis();
    private String status = "Success";
    private CommonMessage message;
    private Object object;
}
