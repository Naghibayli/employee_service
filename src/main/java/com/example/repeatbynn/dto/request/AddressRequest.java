package com.example.repeatbynn.dto.request;

import lombok.Data;

@Data
public class AddressRequest {

    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String city;
}
