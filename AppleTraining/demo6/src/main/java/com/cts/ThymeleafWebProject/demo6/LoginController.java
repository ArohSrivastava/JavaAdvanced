package com.cts.ThymeleafWebProject.demo6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLoginPage()
	{
		return "Login";
	}
	
	@PostMapping("/login")
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model)
	{
		//PERFORM VALIDATION
		return "welcome";
	}
}
