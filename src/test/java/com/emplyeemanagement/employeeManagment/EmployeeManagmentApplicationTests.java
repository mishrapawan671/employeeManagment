package com.emplyeemanagement.employeeManagment;

import com.emplyeemanagement.employeeManagment.Model.Attendence;
import com.emplyeemanagement.employeeManagment.Model.Employee;
import com.emplyeemanagement.employeeManagment.Services.EmployeeService;
import com.emplyeemanagement.employeeManagment.repos.AttendenceRepository;
import com.emplyeemanagement.employeeManagment.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLOutput;

@SpringBootTest
class EmployeeManagmentApplicationTests {

	@Autowired
	public  EmployeeRepository employeeRepository;
	@Autowired
	public  AttendenceRepository attendenceRepository;

	@Autowired
	public EmployeeService employeeService;

	void contextLoads() {
	}

	@Test
	public void insertEmployee()
	{
		Employee employee=new Employee();
		employee.setEmailId("abc@gmail.com");
		employee.setFirstName("abc");
		employee.setLastName("def");
		 employee=employeeRepository.save(employee);
		System.out.println(employee);

	}

	@Test
	public void PaginationTest()
	{
		for(int i=0;i<2;i++)
		{
			Employee employee=new Employee();
			employee.setEmailId("abc@gmail.com");
			employee.setFirstName("abc");
			employee.setLastName("def");
			employeeRepository.save(employee);
		}

		Page<Employee> employeePage=employeeRepository.findAll(Pageable.ofSize(5).withPage(0));

		for (Employee employee:employeePage.getContent()) {
			System.out.println(employee);

		}



	}




}
