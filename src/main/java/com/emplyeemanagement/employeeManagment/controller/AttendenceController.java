package com.emplyeemanagement.employeeManagment.controller;

import com.emplyeemanagement.employeeManagment.DTO.AttendenceDTO;
import com.emplyeemanagement.employeeManagment.Model.Attendence;
import com.emplyeemanagement.employeeManagment.Model.Employee;
import com.emplyeemanagement.employeeManagment.Services.AttendenceService;
import com.emplyeemanagement.employeeManagment.Services.EmployeeService;
import com.emplyeemanagement.employeeManagment.repos.AttendenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class AttendenceController {

    @Autowired
    AttendenceService attendenceService;
    @Autowired
    AttendenceRepository attendenceRepository;

    @Autowired
    EmployeeService employeeService;
    @GetMapping(value = "getAttendence")
    public List<Attendence> getAttendence()
    {
        return attendenceRepository.findAll();

    }


    @GetMapping(value = "markAttendence/{id}")
    public String markAttendence(@PathVariable long id)
    {
        Employee employee=employeeService.findById(id);
        Attendence attendence=new Attendence();
        attendence.setPresent(true);
        attendence.setEmployee(employee);
        attendenceService.save(attendence);
        return "Success";
    }

}
