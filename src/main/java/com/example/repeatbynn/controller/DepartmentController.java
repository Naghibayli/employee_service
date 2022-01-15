package com.example.repeatbynn.controller;

import com.example.repeatbynn.dto.common.CommonResponse;
import com.example.repeatbynn.dto.request.DepartmentRequest;
import com.example.repeatbynn.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<CommonResponse> create(@RequestBody DepartmentRequest request) {
        return ResponseEntity.ok(departmentService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> update(@PathVariable Long id, @RequestBody DepartmentRequest request) {
        return ResponseEntity.ok(departmentService.update(id, request));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @GetMapping("/details")
    public ResponseEntity<CommonResponse> getAllDetailedInfo() {
        return ResponseEntity.ok(departmentService.getAllDetails());
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<CommonResponse> getDetailedInfo(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDetailedInfo(id));
    }
}
