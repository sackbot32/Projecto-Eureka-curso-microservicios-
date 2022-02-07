package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.CustomerRepositoryI;
import com.example.demo.persistence.DeliveryRepository;
import com.example.demo.persistence.ProductRepositoryI;

@RestController
@RequestMapping("/añadir")
public class AddController {
	
	@Autowired
	CustomerRepositoryI cRepo;
	@Autowired
	DeliveryRepository deliverRepo;
	@Autowired
	ProductRepositoryI productRepo;
	
	@GetMapping("")
	public String prueba() {
		
		System.out.println("A proba");
		
		return "Prueba";
	}
	
	@GetMapping("")
	public String randomCustom() {
		
		System.out.println("A proba");
		
		return "Prueba";
	}
	
	@GetMapping("")
	public String randomCustomMulti() {
		
		System.out.println("A proba");
		
		return "Prueba";
	}
	

}
