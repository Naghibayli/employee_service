package com.example.repeatbynn.service.impl;

import com.example.repeatbynn.dto.request.DepartmentRequest;
import com.example.repeatbynn.dto.response.DepartmentDetailsResponse;
import com.example.repeatbynn.dto.response.DepartmentResponse;
import com.example.repeatbynn.entity.Department;
import com.example.repeatbynn.entity.Employee;
import com.example.repeatbynn.mapper.DepartmentMapper;
import com.example.repeatbynn.repository.DepartmentRepository;
import com.example.repeatbynn.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentResponse create(DepartmentRequest request) {
        return departmentMapper.toResponse(departmentRepository.save(departmentMapper.toEntity(request)));
    }

    @Override
    public DepartmentResponse update(Long id, DepartmentRequest request) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            Department newDepartment = departmentMapper.toEntity(request);
            newDepartment.setId(id);
            newDepartment.setCreatedAt(department.get().getCreatedAt());
            return departmentMapper.toResponse(departmentRepository.save(newDepartment));
        }
        return null;
    }

    @Override
    public DepartmentResponse findById(Long id) {
        return departmentMapper.toResponse(departmentRepository.findById(id).get());
    }

    @Override
    public List<DepartmentResponse> findAll() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResponse> responses = new ArrayList<>();
        for (Department department : departments) {
            responses.add(departmentMapper.toResponse(department));
        }
        return responses;
    }

    @Override
    public DepartmentDetailsResponse getDetailedInfo(Long id) {
        return departmentMapper.toFullResponse(departmentRepository.findById(id).get());
    }

    public List<DepartmentDetailsResponse> getAllDetails(){
        return departmentRepository.findAll().stream().map(departmentMapper::toFullResponse).collect(Collectors.toList());
    }
}
