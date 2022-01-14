package com.example.repeatbynn.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AddressResponse implements Serializable {

    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String city;
    private LocalDateTime createdAt;
}
