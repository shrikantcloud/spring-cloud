package com.sa.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sa.cloud.model.Employee;

@RestController
public class TestController {
	
	@RequestMapping(value = "/employee" , method = RequestMethod.GET)
	public Employee fistPage() {
		Employee emp = new Employee();
		emp.setEmpId("1");
		emp.setName("Nikki");
		emp.setDesignation("Manager");
		emp.setSalary(99999.00);
		return emp;
	}
}
