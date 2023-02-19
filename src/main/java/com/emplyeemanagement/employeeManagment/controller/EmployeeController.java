package com.emplyeemanagement.employeeManagment.controller;

import com.emplyeemanagement.employeeManagment.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.emplyeemanagement.employeeManagment.repos.EmployeeRepository;
import org.springframework.data.domain.Page;

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

    @GetMapping("/employees/{page}")
    public Page<Employee> getEmployeeByPage(@PathVariable int page)
    {
//        List<Employee> list=employeeRepository.findAll(Pageable.ofSize(5).withPage(page))
//                                                .stream()
//                                                .toList();

        return employeeRepository.findAll(Pageable.ofSize(5).withPage(page));


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
