package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.persistence.Customer;
import com.example.demo.persistence.CustomerRepositoryI;
import com.example.demo.persistence.Delivery;
import com.example.demo.persistence.DeliveryRepository;
import com.example.demo.persistence.Product;
import com.example.demo.persistence.ProductRepositoryI;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	CustomerRepositoryI customerRepo;
	@Autowired
	DeliveryRepository deliverRepo;
	@Autowired
	ProductRepositoryI productRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	
	@Override
	public void run(String...args) {
			
		Customer c1 = new Customer();
		List<Delivery> dell = new ArrayList<Delivery>();
		
		c1.setAddress("Cazsa");
		c1.setIdentityDoc(28478748);
		c1.setName("paco");
		c1.setDeliveries(dell);
	//	customerRepo.save(c1);
		
		
		
		Product p1 = new Product();
		
		
		p1.setCode("ochinti");
		p1.setName("papas");
		p1.setPrice(80);
		p1.setDeliveries(dell);
		
		
		
		Delivery d1 = new Delivery();
		
		List<Product> producto = new ArrayList<Product>();
		
		producto.add(p1);
		
		d1.setCode("codegueo");
		d1.setCustomer(c1);
		d1.setProducts(producto);
		d1.setUpdateUser("usor");
		
		System.out.println(d1);
		
		deliverRepo.save(d1);
		
		System.out.println("Los customers" + customerRepo.findAll());
		System.out.println(deliverRepo.findAll());
		System.out.println(productRepo.findAll());
		
		
		
	}

}
