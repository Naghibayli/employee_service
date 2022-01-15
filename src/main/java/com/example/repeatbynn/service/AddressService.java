package com.example.repeatbynn.service;

import com.example.repeatbynn.dto.common.CommonResponse;
import com.example.repeatbynn.dto.request.AddressRequest;
import com.example.repeatbynn.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {

    CommonResponse create(AddressRequest request);

    CommonResponse update(Long id, AddressRequest request);

    CommonResponse findById(Long id);

    CommonResponse findAll();
}
