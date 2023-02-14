package com.emplyeemanagement.employeeManagment.controller;

import com.emplyeemanagement.employeeManagment.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.emplyeemanagement.employeeManagment.repos.EmployeeRepository;

import java.util.List;
@CrossOrigin("http://localhost:3000/")
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

    @PostMapping(value = "/AddEmployee",consumes = "application/json")
        public ResponseEntity saveEmployee( @RequestBody Employee employee)
    {
        if(employeeRepository.save(employee)!=null)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED).header("Message","Employee Saved").build();
        }
        else
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }

    }

}
