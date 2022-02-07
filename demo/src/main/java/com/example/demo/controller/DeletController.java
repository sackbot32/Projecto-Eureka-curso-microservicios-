package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eliminar")
public class DeletController {
	
	@GetMapping("")
	public String prueba() {
		
		System.out.println("A proba");
		
		return "Prueba";
	}

}
