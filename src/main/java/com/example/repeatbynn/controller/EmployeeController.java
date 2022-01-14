package com.example.repeatbynn.controller;

import com.example.repeatbynn.dto.common.CommonResponse;
import com.example.repeatbynn.dto.request.EmployeeRequest;
import com.example.repeatbynn.service.EmployeeService;
import com.example.repeatbynn.util.TimeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final TimeConverter timeConverter;

    @PostMapping
    public ResponseEntity<CommonResponse> create(@RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> update(@PathVariable Long id, @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.update(id, request));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping("/createdAt")
    public ResponseEntity<CommonResponse> getByCreatedAt(@RequestParam String startDate,
                                                         @RequestParam String endDate) {
        return ResponseEntity.ok(employeeService.findByCreatedAtBetween(timeConverter.toLocalDateTime(startDate),
                timeConverter.toLocalDateTime(endDate)));
    }
}
