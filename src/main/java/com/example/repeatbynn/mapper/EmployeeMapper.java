package com.example.repeatbynn.mapper;

import com.example.repeatbynn.dto.request.EmployeeRequest;
import com.example.repeatbynn.dto.response.EmployeeResponse;
import com.example.repeatbynn.entity.Employee;
import com.example.repeatbynn.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final AddressMapper addressMapper;
    private final DepartmentRepository departmentRepository;
    private final JobDetailMapper jobDetailMapper;

    public Employee toEntity(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setSurname(request.getSurname());
        employee.setBirthDate(request.getBirthDate());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setAddress(addressMapper.toEntity(request.getAddress()));
        employee.setDepartment(departmentRepository.findById(request.getDepartment()).get());
        employee.setJobDetail(jobDetailMapper.toEntity(request.getJobDetail()));
        return employee;
    }

    public EmployeeResponse toResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setSurname(employee.getSurname());
        employeeResponse.setBirthDate(employee.getBirthDate());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setPhone(employee.getPhone());
        employeeResponse.setCreatedAt(employee.getCreatedAt());
        employeeResponse.setDepartmentName(employee.getDepartment().getDepartmentName());
        employeeResponse.setAddress(addressMapper.toResponse(employee.getAddress()));
        employeeResponse.setJobDetail(jobDetailMapper.toResponse(employee.getJobDetail()));
        return employeeResponse;
    }


}
