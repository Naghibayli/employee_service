package com.example.repeatbynn.service.impl;

import com.example.repeatbynn.dto.request.AddressRequest;
import com.example.repeatbynn.dto.response.AddressResponse;
import com.example.repeatbynn.entity.Address;
import com.example.repeatbynn.mapper.AddressMapper;
import com.example.repeatbynn.repository.AddressRepository;
import com.example.repeatbynn.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponse create(AddressRequest request) {
        return addressMapper.toResponse(addressRepository.save(addressMapper.toEntity(request)));
    }

    @Override
    public AddressResponse update(Long id, AddressRequest request) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address newAddress = addressMapper.toEntity(request);
            newAddress.setId(id);
            newAddress.setCreatedAt(address.get().getCreatedAt());
            return addressMapper.toResponse(addressRepository.save(newAddress));
        }
        return null;
    }

    @Override
    public AddressResponse findById(Long id) {
        return addressMapper.toResponse(addressRepository.findById(id).get());
    }

    @Override
    public List<AddressResponse> findAll() {
        List<Address> addresses = addressRepository.findAll();
        List<AddressResponse> responses = new ArrayList<>();
        for (Address address : addresses) {
            responses.add(addressMapper.toResponse(address));
        }
        return responses;
    }
}