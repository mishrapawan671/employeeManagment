package com.emplyeemanagement.employeeManagment.controller;

import com.emplyeemanagement.employeeManagment.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emplyeemanagement.employeeManagment.repos.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //get All Employee List
    @GetMapping ("/employees")
    public List<Employee> getAllEmployee()
    {
        return employeeRepository.findAll();
    }

}
