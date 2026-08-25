package com.yahya.erphrapp.employee.repository;

import com.yahya.erphrapp.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
