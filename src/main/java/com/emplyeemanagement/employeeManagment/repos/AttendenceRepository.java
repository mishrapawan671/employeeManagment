package com.emplyeemanagement.employeeManagment.repos;

import com.emplyeemanagement.employeeManagment.Model.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendenceRepository extends JpaRepository<Attendence, Long> {
}