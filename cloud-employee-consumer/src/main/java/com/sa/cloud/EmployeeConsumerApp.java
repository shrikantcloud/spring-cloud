package com.sa.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import com.sa.cloud.controller.ConsumerControllerClientUsingFeign;

@SpringBootApplication
@EnableFeignClients
public class EmployeeConsumerApp {

	public static void main(String[] args) {
		ApplicationContext appCtx = SpringApplication.run(EmployeeConsumerApp.class, args);
		ConsumerControllerClientUsingFeign feignConsumerClient = appCtx.getBean(ConsumerControllerClientUsingFeign.class);
		System.out.println(feignConsumerClient);
		feignConsumerClient.getEmployee();
//		ConsumerControllerClient consumerClient = appCtx.getBean(ConsumerControllerClient.class);
//		System.out.println(consumerClient);
//		consumerClient.getEmployee();
		//callGetEmployeeInLoopToCheckCircuitBreaker(consumerClient);
		// TestController testController = appCtx.getBean(TestController.class);
		// System.out.println(testController);
		// testController.getEmployee();

	}

	// Stress Test - Circuit breaker
//	private static void callGetEmployeeInLoopToCheckCircuitBreaker(ConsumerControllerClient consumerClient) {
//		for (int i = 0; i < 100; i++) {
//			consumerClient.getEmployee();
//		}
//	}
}