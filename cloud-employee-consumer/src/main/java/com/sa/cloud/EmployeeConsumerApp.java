package com.sa.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sa.cloud.controller.ConsumerControllerClient;

@SpringBootApplication
public class EmployeeConsumerApp {

	public static void main(String[] args) {
		ApplicationContext appCtx = SpringApplication.run(EmployeeConsumerApp.class, args);
		ConsumerControllerClient consumerClient = appCtx.getBean(ConsumerControllerClient.class);
		System.out.println(consumerClient);
		consumerClient.getEmployee();
		// TestController testController = appCtx.getBean(TestController.class);
		// System.out.println(testController);
		// testController.getEmployee();
	}

}
