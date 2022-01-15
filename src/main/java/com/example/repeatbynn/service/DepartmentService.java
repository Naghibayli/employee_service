package com.example.repeatbynn.service;

import com.example.repeatbynn.dto.common.CommonResponse;
import com.example.repeatbynn.dto.request.DepartmentRequest;
import com.example.repeatbynn.dto.response.DepartmentDetailsResponse;
import com.example.repeatbynn.dto.response.DepartmentResponse;

import java.math.BigDecimal;
import java.util.List;

public interface DepartmentService {

    CommonResponse create(DepartmentRequest request);

    CommonResponse update(Long id, DepartmentRequest request);

    CommonResponse findById(Long id);

    CommonResponse getDetailedInfo(Long id);

    CommonResponse findAll();

    CommonResponse getAllDetails();

}
