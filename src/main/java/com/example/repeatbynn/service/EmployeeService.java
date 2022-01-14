package com.example.repeatbynn.service;

import com.example.repeatbynn.dto.common.CommonResponse;
import com.example.repeatbynn.dto.request.EmployeeRequest;
import com.example.repeatbynn.dto.response.EmployeeResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeService {

    CommonResponse create(EmployeeRequest request);

    CommonResponse update(Long id, EmployeeRequest request);

    CommonResponse findById(Long id);

    CommonResponse findAll();

    CommonResponse findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}