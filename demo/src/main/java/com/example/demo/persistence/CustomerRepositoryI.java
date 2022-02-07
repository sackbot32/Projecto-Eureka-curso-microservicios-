package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoryI extends JpaRepository<Customer, Long> {
	
	public Customer findByidentityDoc(final String identityDoc);

}
