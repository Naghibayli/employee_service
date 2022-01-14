package com.example.repeatbynn.dto.common;

import lombok.Data;

@Data
public class CommonResponse {

    private Long time = System.currentTimeMillis();
    private String status = "Success";
    private CommonMessage message;
    private Object object;


//    public Long getTime() {
//        return time;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public CommonMessage getMessage() {
//        return message;
//    }
//
//    public Object getObject() {
//        return object;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public void setMessage(CommonMessage message) {
//        this.message = message;
//    }
//
//    public void setObject(Object object) {
//        this.object = object;
//    }
}
