package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio: T_CUSTOMER
 * 
 * @author NTT DATA
 *
 */
@Repository
public interface CustomerRepositoryI extends JpaRepository<Customer, Long> {

	/**
	 * Obtención de cliente por documento de identidad.
	 * 
	 * @param identityDoc
	 * @return Customer
	 */
	public Customer findByIdentityDoc(final String identityDoc);

}
