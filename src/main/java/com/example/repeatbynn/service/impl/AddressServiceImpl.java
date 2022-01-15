package com.example.repeatbynn.service.impl;

import com.example.repeatbynn.dto.common.CommonMessage;
import com.example.repeatbynn.dto.common.CommonResponse;
import com.example.repeatbynn.dto.request.AddressRequest;
import com.example.repeatbynn.dto.response.AddressResponse;
import com.example.repeatbynn.entity.Address;
import com.example.repeatbynn.exception.BusinessExceptionEnum;
import com.example.repeatbynn.exception.NotFoundException;
import com.example.repeatbynn.mapper.AddressMapper;
import com.example.repeatbynn.repository.AddressRepository;
import com.example.repeatbynn.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public CommonResponse create(AddressRequest request) {
        CommonResponse response = new CommonResponse();
        response.setMessage(new CommonMessage());
        response.setObject(addressMapper.toResponse(addressRepository.save(addressMapper.toEntity(request))));
        return response;
    }

    @Override
    public CommonResponse update(Long id, AddressRequest request) {
        CommonResponse response = new CommonResponse();
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address newAddress = addressMapper.toEntity(request);
            newAddress.setId(id);
            newAddress.setCreatedAt(address.get().getCreatedAt());
            response.setMessage(new CommonMessage());
            response.setObject(addressMapper.toResponse(addressRepository.save(newAddress)));
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.ADDRESS_NOT_FOUND, id);
    }

    @Override
    public CommonResponse findById(Long id) {
        CommonResponse response = new CommonResponse();
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            response.setMessage(new CommonMessage());
            response.setObject(addressMapper.toResponse(addressRepository.findById(id).get()));
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.ADDRESS_NOT_FOUND, id);
    }

    @Override
    public CommonResponse findAll() {
        CommonResponse response = new CommonResponse();
        List<Address> addresses = addressRepository.findAll();
        if (addresses.size() != 0) {
            List<AddressResponse> responses = new ArrayList<>(addresses.stream().map(addressMapper::toResponse).collect(Collectors.toList()));
            response.setMessage(new CommonMessage());
            response.setObject(responses);
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.ADDRESS_NOT_FOUND);
    }
}