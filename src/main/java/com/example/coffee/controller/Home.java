package com.example.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
	
	@GetMapping({"/","home"})
	public String doHome() {
		
		return "/home/home";
	}
	/*
	@GetMapping({"/coffee"})
	public String doCoffee() {
		return "/v1/coffee";
	}
	*/
	
}
