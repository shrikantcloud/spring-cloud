package com.sa.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sa.cloud.model.Employee;

@Controller
public class ConsumerControllerClientUsingFeign {

	@Autowired
	private RemoteCallService loadBalancer;
	
	@HystrixCommand(fallbackMethod= "defaultResponse")
	public void getEmployee() {
		System.out.println("<========Consumer-getEmployee===>");
		try {
			Employee emp = loadBalancer.getData();
			System.out.println("emp obj:====>"+emp);
			System.out.println("Data ===>"+emp.getEmpId());
		} catch (Exception ex) {
			ex.printStackTrace(); 
			System.out.println();
		}
	}
	
	public void defaultResponse(String err) {
        System.out.println("You are seeing this fallback response because the underlying microservice is down.");
        err = "Fallback error as the microservice is down.";
        return;
    }
}
