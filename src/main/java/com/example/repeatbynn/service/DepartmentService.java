package com.example.repeatbynn.service;

import com.example.repeatbynn.dto.request.DepartmentRequest;
import com.example.repeatbynn.dto.response.DepartmentDetailsResponse;
import com.example.repeatbynn.dto.response.DepartmentResponse;

import java.math.BigDecimal;
import java.util.List;

public interface DepartmentService {

    DepartmentResponse create(DepartmentRequest request);

    DepartmentResponse update(Long id, DepartmentRequest request);

    DepartmentResponse findById(Long id);

    DepartmentDetailsResponse getDetailedInfo(Long id);

    List<DepartmentResponse> findAll();

    public List<DepartmentDetailsResponse> getAllDetails();

}
