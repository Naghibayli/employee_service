package com.example.repeatbynn.controller;

import com.example.repeatbynn.dto.request.DepartmentRequest;
import com.example.repeatbynn.dto.response.DepartmentDetailsResponse;
import com.example.repeatbynn.dto.response.DepartmentResponse;
import com.example.repeatbynn.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponse> create(@RequestBody DepartmentRequest request) {
        return ResponseEntity.ok(departmentService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> update(@PathVariable Long id, @RequestBody DepartmentRequest request) {
        return ResponseEntity.ok(departmentService.update(id, request));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @GetMapping("/details")
    public ResponseEntity<List<DepartmentDetailsResponse>> getAllDetailedInfo() {
        return ResponseEntity.ok(departmentService.getAllDetails());
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<DepartmentDetailsResponse> getDetailedInfo(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDetailedInfo(id));
    }
}
