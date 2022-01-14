package com.example.repeatbynn.repository;

import com.example.repeatbynn.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}
