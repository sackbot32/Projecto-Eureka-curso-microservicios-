package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio: T_PRODUCT
 * 
 * @author NTT_DATA
 *
 */
@Repository
public interface ProductRepositoryI extends JpaRepository<Product, Long> {

	/**
	 * Búsqueda de producto por código.
	 * 
	 * @param code
	 * @return Product
	 */
	public Product findByCode(final String code);

	/**
	 * Búsqueda de productos por nombre.
	 * 
	 * @param name
	 * @return List<Product>
	 */
	public List<Product> findByName(final String name);

}
