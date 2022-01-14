package com.example.repeatbynn.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class JobDetailRequest {

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isPresent;
    private BigDecimal salary;
}
