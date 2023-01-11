package com.cts.microservice.Microservices1_ServiceRegistrationAndDiscoveryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Demo8MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo8MicroservicesApplication.class, args);
	}

}
