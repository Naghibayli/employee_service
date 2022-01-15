package com.example.repeatbynn.controller;

import com.example.repeatbynn.dto.common.CommonResponse;
import com.example.repeatbynn.dto.request.AddressRequest;
import com.example.repeatbynn.dto.response.AddressResponse;
import com.example.repeatbynn.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<CommonResponse> create(@RequestBody AddressRequest request) {
        return ResponseEntity.ok(addressService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> update(@PathVariable Long id, @RequestBody AddressRequest request) {
        return ResponseEntity.ok(addressService.update(id, request));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }
}
