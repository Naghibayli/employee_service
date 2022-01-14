package com.example.repeatbynn.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class JobDetailResponse {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isPresent;
    private BigDecimal salary;
}
