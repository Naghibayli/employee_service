package com.example.repeatbynn.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private Long department;
    private AddressRequest address;
    private JobDetailRequest jobDetail;
}
