package com.nttdata.repositories;

import java.util.List;

/**
 * Repositorio personalizado: T_DELIVERY
 * 
 * @author NTT DATA
 *
 */
public interface DeliveryRepositoryCustom {
	
	/**
	 * Obtención de pedidos por patrón en nombre de cliente.
	 * 
	 * @param namePattern
	 * @return List<Delivery>
	 */
	public List<Delivery> getByCustomerNamePattern(final String namePattern);

}
