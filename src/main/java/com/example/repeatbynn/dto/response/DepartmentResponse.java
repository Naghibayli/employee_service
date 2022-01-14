package com.example.repeatbynn.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DepartmentResponse {

    private Long id;
    private String departmentName;
    private LocalDateTime createdAt;
}
