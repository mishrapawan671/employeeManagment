package com.emplyeemanagement.employeeManagment.repos;

import com.emplyeemanagement.employeeManagment.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
