package com.sa.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sa.cloud.model.Employee;

@RestController
public class TestController {
	
	@RequestMapping(value = "/employee" , method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee fistPage() {
		System.out.println("Inside 1st Page");
		Employee emp = new Employee();
		emp.setEmpId("1");
		emp.setName("Robert");
		emp.setDesignation("Manager");
		emp.setCurrency("USD");
		emp.setSalary(9999999.00);
		
		if(emp.getEmpId().equals("2")) {
			throw new RuntimeException();
		}
		return emp;
	}
	
	public Employee getDataFallBack() {
		System.out.println("Inside fallback");
		Employee emp = new Employee();
		emp.setEmpId("fallback - 2 Quit");
		emp.setName("fallback - Vipul");
		emp.setDesignation("fallback - Developer");
		emp.setCurrency("fallback - USD");
		emp.setSalary(99999.00);
		return emp;
	}
	
	
}
