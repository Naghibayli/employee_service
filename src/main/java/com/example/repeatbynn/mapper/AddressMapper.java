package com.example.repeatbynn.mapper;

import com.example.repeatbynn.dto.request.AddressRequest;
import com.example.repeatbynn.dto.response.AddressResponse;
import com.example.repeatbynn.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEntity(AddressRequest request) {
        Address address = new Address();
        address.setAddressLine1(request.getAddressLine1());
        address.setAddressLine2(request.getAddressLine2());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());
        return address;
    }

    public AddressResponse toResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setAddressLine1(address.getAddressLine1());
        addressResponse.setAddressLine2(address.getAddressLine2());
        addressResponse.setCity(address.getCity());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setCreatedAt(address.getCreatedAt());
        return addressResponse;
    }
}
