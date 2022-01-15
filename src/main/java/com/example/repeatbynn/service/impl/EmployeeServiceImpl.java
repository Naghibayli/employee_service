package com.example.repeatbynn.service.impl;

import com.example.repeatbynn.dto.common.CommonMessage;
import com.example.repeatbynn.dto.common.CommonResponse;
import com.example.repeatbynn.dto.request.EmployeeRequest;
import com.example.repeatbynn.dto.response.EmployeeResponse;
import com.example.repeatbynn.entity.Address;
import com.example.repeatbynn.entity.Employee;
import com.example.repeatbynn.exception.BusinessExceptionEnum;
import com.example.repeatbynn.exception.NotFoundException;
import com.example.repeatbynn.mapper.EmployeeMapper;
import com.example.repeatbynn.repository.AddressRepository;
import com.example.repeatbynn.repository.EmployeeRepository;
import com.example.repeatbynn.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final AddressRepository addressRepository;

    @Override
    public CommonResponse create(EmployeeRequest request) {
        CommonResponse response = new CommonResponse();
        Employee employee = employeeMapper.toEntity(request);
        Address address = employee.getAddress();
        address.setEmployee(employee);
        employeeRepository.save(employee);
        addressRepository.save(address);
        response.setObject(employeeMapper.toResponse(employee));
        return response;
    }

    @Override
    public CommonResponse update(Long id, EmployeeRequest request) {
        CommonResponse response = new CommonResponse();
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        if (foundEmployee.isPresent()) {
            Employee newEmployee = employeeMapper.toEntity(request);
            newEmployee.setId(id);
            newEmployee.setCreatedAt(foundEmployee.get().getCreatedAt());
            Optional<Address> foundAddress = addressRepository.findById(request.getAddress().getId());
            Address address = newEmployee.getAddress();
            address.setId(request.getAddress().getId());
            address.setEmployee(newEmployee);
            address.setCreatedAt(foundAddress.get().getCreatedAt());
            addressRepository.save(address);
            response.setObject(employeeMapper.toResponse(employeeRepository.save(newEmployee)));
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, id);
    }

    @Override
    public CommonResponse findById(Long id) {
        CommonResponse response = new CommonResponse();
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            response.setObject(employeeMapper.toResponse(employee.get()));
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, id);
    }

    @Override
    public CommonResponse findAll() {
        CommonResponse response = new CommonResponse();
        List<Employee> employees = employeeRepository.findAll();
        if (employees.size() != 0) {
            List<EmployeeResponse> responses = new ArrayList<>(employees.stream().map(employeeMapper::toResponse).collect(Collectors.toList()));
            response.setMessage(new CommonMessage());
            response.setObject(responses);
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND);
    }

    @Override
    public CommonResponse findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate) {
        CommonResponse response = new CommonResponse();
        List<Employee> employees = employeeRepository.findByCreatedAtBetween(startDate, endDate);
        if (employees.size() != 0) {
            List<EmployeeResponse> responses = new ArrayList<>(employees.stream().map(employeeMapper::toResponse).collect(Collectors.toList()));
            response.setObject(responses);
            return response;
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND);
    }
}