package com.cts.project3.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Demo3Application {

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(Demo3Application.class);
//		app.setDefaultProperties(Collections.singletonMap("server.port","8081"));
//		app.run(args);
		SpringApplication.run(Demo3Application.class, args);
	}
	
	@GetMapping("/hello") //Always use @RestController with mapping annotations to avoid explicit mapping for /error
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return String.format("Hello %s!", name);
//		Check on browser- localhost:8080/hello?name=Aroh
//		where, '?' is called the Query String operator in URL
	}
}
