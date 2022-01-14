package com.example.repeatbynn.service;

import com.example.repeatbynn.dto.request.AddressRequest;
import com.example.repeatbynn.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {

    AddressResponse create(AddressRequest request);

    AddressResponse update(Long id, AddressRequest request);

    AddressResponse findById(Long id);

    List<AddressResponse> findAll();
}
