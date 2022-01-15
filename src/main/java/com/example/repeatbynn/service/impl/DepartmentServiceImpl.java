package com.example.repeatbynn.service.impl;

import com.example.repeatbynn.dto.common.CommonMessage;
import com.example.repeatbynn.dto.common.CommonResponse;
import com.example.repeatbynn.dto.request.DepartmentRequest;
import com.example.repeatbynn.dto.response.DepartmentDetailsResponse;
import com.example.repeatbynn.dto.response.DepartmentResponse;
import com.example.repeatbynn.entity.Department;
import com.example.repeatbynn.exception.BusinessExceptionEnum;
import com.example.repeatbynn.exception.NotFoundException;
import com.example.repeatbynn.mapper.DepartmentMapper;
import com.example.repeatbynn.repository.DepartmentRepository;
import com.example.repeatbynn.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public CommonResponse create(DepartmentRequest request) {
        CommonResponse response = new CommonResponse();
        response.setMessage(new CommonMessage());
        response.setObject(departmentMapper.toResponse(departmentRepository.save(departmentMapper.toEntity(request))));
        return response;
    }

    @Override
    public CommonResponse update(Long id, DepartmentRequest request) {
        CommonResponse response = new CommonResponse();
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            Department newDepartment = departmentMapper.toEntity(request);
            newDepartment.setId(id);
            newDepartment.setCreatedAt(department.get().getCreatedAt());
            response.setMessage(new CommonMessage());
            response.setObject(departmentMapper.toResponse(departmentRepository.save(newDepartment)));
        }
        throw new NotFoundException(BusinessExceptionEnum.DEPARTMENT_BY_ID_NOT_FOUND, id);
    }

    @Override
    public CommonResponse findById(Long id) {
        CommonResponse response = new CommonResponse();
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            response.setMessage(new CommonMessage());
            response.setObject(departmentMapper.toResponse(department.get()));
        }
        throw new NotFoundException(BusinessExceptionEnum.DEPARTMENT_BY_ID_NOT_FOUND, id);
    }

    @Override
    public CommonResponse findAll() {
        CommonResponse response = new CommonResponse();
        List<Department> departments = departmentRepository.findAll();
        if (departments.size() != 0) {
            List<DepartmentResponse> responses = new ArrayList<>(departments.stream().map(departmentMapper::toResponse).collect(Collectors.toList()));
            response.setMessage(new CommonMessage());
            response.setObject(responses);
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.DEPARTMENT_BY_ID_NOT_FOUND);
    }

    @Override
    public CommonResponse getDetailedInfo(Long id) {
        CommonResponse response = new CommonResponse();
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            response.setMessage(new CommonMessage());
            response.setObject(departmentMapper.toFullResponse(department.get()));
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.DEPARTMENT_BY_ID_NOT_FOUND, id);
    }

    public CommonResponse getAllDetails() {
        CommonResponse response = new CommonResponse();
        List<Department> departments = departmentRepository.findAll();
        if (departments.size() != 0) {
            List<DepartmentDetailsResponse> responses = new ArrayList<>(departments.stream().map(departmentMapper::toFullResponse).collect(Collectors.toList()));
            response.setMessage(new CommonMessage());
            response.setObject(responses);
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.DEPARTMENT_BY_ID_NOT_FOUND);
    }
}
