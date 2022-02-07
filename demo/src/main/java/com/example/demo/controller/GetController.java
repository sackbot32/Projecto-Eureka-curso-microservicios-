package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.Customer;
import com.example.demo.persistence.CustomerRepositoryI;
import com.example.demo.persistence.Delivery;
import com.example.demo.persistence.DeliveryRepository;
import com.example.demo.persistence.Product;
import com.example.demo.persistence.ProductRepositoryI;

@RestController
@RequestMapping("/cojer")
public class GetController {
	
	@Autowired
	CustomerRepositoryI cRepo;
	@Autowired
	DeliveryRepository deliverRepo;
	@Autowired
	ProductRepositoryI productRepo;
	
	@GetMapping("/CUSTOMER")
	public String getAllCustom() {
			
		return cRepo.findAll().toString();
	}
	
	@GetMapping("/CUSTOMER/{index}")
	public String getIDCustom(@RequestParam("index") String id) {
		
		
		Optional<Customer> custom = cRepo.findById(Long.parseLong(id));
		if(custom.isPresent()) {
			return "ERROR, no existe";
		} else {
			return custom.toString();
		}
	}
	
	
	@GetMapping("/PRODUCT")
	public String getAllProduct() {
			
		return deliverRepo.findAll().toString();
	}
	
	@GetMapping("/PRODUCT/{index}")
	public String getIDProduct(@RequestParam long id) {
		
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
			return "ERROR, no existe";
		} else {
			return product.toString();
		}
	}
	
	@GetMapping("/DELIVER")
	public String getAllDeliver() {
			
		return productRepo.findAll().toString();
	}
	
	@GetMapping("/DELIVER/{index}")
	public String getIDDeliver(@RequestParam long id) {
		
		Optional<Delivery> deliver = deliverRepo.findById(id);
		if(deliver.isPresent()) {
			return "ERROR, no existe";
		} else {
			return deliver.toString();
		}
	}
	

}
