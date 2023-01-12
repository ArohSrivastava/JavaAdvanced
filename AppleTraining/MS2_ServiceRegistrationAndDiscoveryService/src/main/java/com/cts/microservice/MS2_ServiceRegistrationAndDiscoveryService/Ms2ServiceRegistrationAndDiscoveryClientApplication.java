package com.cts.microservice.MS2_ServiceRegistrationAndDiscoveryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Ms2ServiceRegistrationAndDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms2ServiceRegistrationAndDiscoveryClientApplication.class, args);
	}

}
