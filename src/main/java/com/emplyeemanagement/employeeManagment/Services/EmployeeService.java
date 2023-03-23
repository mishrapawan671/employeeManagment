package com.emplyeemanagement.employeeManagment.Services;

import com.emplyeemanagement.employeeManagment.DTO.EmployeeDTO;
import com.emplyeemanagement.employeeManagment.Model.Employee;
import com.emplyeemanagement.employeeManagment.repos.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public  Employee getDetails(long id) {
        return employeeRepository.findById(id).get();
    }

    public List<EmployeeDTO> getAllEmployee()
    {
        return employeeRepository.findAll()
                .stream()
                .map(employee ->modelMapper.map(employee,EmployeeDTO.class) )
                .collect(Collectors.toList());
    }

    public Page<Employee> getEmployeeByPage (int page) {
             return employeeRepository.findAll(Pageable.ofSize(5).withPage(page));


    }



    public Employee save(Employee employee) {
       return employeeRepository.save(employee);
    }

    public Employee findById(long id)
    {
        return employeeRepository.findById(id).get();
    }
}
