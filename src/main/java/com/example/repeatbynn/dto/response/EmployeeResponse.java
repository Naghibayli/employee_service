package com.example.repeatbynn.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EmployeeResponse implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private LocalDateTime createdAt;
    private String departmentName;
    private AddressResponse address;
    private JobDetailResponse jobDetail;
}
