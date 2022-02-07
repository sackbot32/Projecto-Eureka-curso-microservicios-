package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryI extends JpaRepository<Product, Long> {
	
	public List<Product> findByName(final String name);

}
