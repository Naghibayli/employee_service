package com.example.repeatbynn.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class DepartmentDetailsResponse implements Serializable {

    private Long id;
    private String departmentName;
    private LocalDateTime createdAt;
    private int employeeSize;
    private BigDecimal fullSalary;
    private List<EmployeeResponse> employees;
}
