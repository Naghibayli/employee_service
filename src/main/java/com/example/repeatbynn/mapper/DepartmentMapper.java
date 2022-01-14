package com.example.repeatbynn.mapper;

import com.example.repeatbynn.dto.request.DepartmentRequest;
import com.example.repeatbynn.dto.response.DepartmentDetailsResponse;
import com.example.repeatbynn.dto.response.DepartmentResponse;
import com.example.repeatbynn.dto.response.EmployeeResponse;
import com.example.repeatbynn.entity.Department;
import com.example.repeatbynn.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentMapper {

    private final EmployeeMapper employeeMapper;

    public Department toEntity(DepartmentRequest request) {
        Department department = new Department();
        department.setDepartmentName(request.getDepartmentName());
        return department;
    }

    public DepartmentResponse toResponse(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setDepartmentName(department.getDepartmentName());
        departmentResponse.setCreatedAt(department.getCreatedAt());
        return departmentResponse;
    }

    public DepartmentDetailsResponse toFullResponse(Department department) {
        DepartmentDetailsResponse departmentResponse = new DepartmentDetailsResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setDepartmentName(department.getDepartmentName());
        departmentResponse.setCreatedAt(department.getCreatedAt());
        List<Employee> employees = department.getEmployees();
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for (Employee employee : employees) {
            employeeResponses.add(employeeMapper.toResponse(employee));
            departmentResponse.setFullSalary(employee.getJobDetail().getSalary());
        }
        departmentResponse.setEmployees(employeeResponses);
        departmentResponse.setEmployeeSize(employeeResponses.size());
        return departmentResponse;
    }
}
