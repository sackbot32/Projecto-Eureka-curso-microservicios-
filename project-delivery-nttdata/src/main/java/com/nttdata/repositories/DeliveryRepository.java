package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio: T_DELIVERY
 * 
 * @author NTT DATA
 *
 */
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>, DeliveryRepositoryCustom {

	/**
	 * Buscar a través del código de pedido.
	 * 
	 * @param code
	 * @return Delivery
	 */
	public Delivery findByCode(final String code);

}
