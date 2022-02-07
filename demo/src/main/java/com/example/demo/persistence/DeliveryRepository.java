package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
	
	public Delivery findByCode(final String code);

}
