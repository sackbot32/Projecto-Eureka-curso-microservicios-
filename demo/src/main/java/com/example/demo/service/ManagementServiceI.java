package com.example.demo.service;

import java.util.List;

import com.example.demo.persistence.Customer;
import com.example.demo.persistence.Delivery;
import com.example.demo.persistence.Product;

public interface ManagementServiceI {
	
	
	
	public void addCustomer(Customer c);
	
	public void addDelivery(Delivery d);
	
	public void addProduct(Product d);
	
	public List<Customer> getAllCustomers();
	
	public List<Delivery> getAllDeliveries();
	
	public List<Product> getAllProducts();
	
}
