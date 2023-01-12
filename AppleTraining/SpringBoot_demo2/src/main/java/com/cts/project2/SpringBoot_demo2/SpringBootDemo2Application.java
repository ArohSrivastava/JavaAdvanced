package com.cts.project2.SpringBoot_demo2;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemo2Application {

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(SpringBootDemo2Application.class);
		app.setDefaultProperties(Collections.singletonMap("server.port","8081"));
		app.run(args);
		//SpringApplication.run(Demo2Application.class, args);
	}

}
