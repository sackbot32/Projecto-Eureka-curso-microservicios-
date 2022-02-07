package com.nttdata.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Repositorio personalizado: T_DELIVERY
 * 
 * @author NTT DATA
 *
 */
public class DeliveryRepositoryImpl implements DeliveryRepositoryCustom {

	/** Entity manager */
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Delivery> getByCustomerNamePattern(final String namePattern) {

		// Consulta.
		final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Delivery> cquery = cb.createQuery(Delivery.class);
		final Root<Delivery> rootP = cquery.from(Delivery.class);
		final Join<Delivery, Customer> pJoinT = rootP.join("customer");

		// Where.
		final Predicate pr1 = cb.like(pJoinT.<String> get("name"), namePattern);

		// Consulta.
		cquery.select(rootP).where(pr1);

		// Ejecución de consulta.
		final List<Delivery> results = entityManager.createQuery(cquery).getResultList();

		return results;
	}

}
