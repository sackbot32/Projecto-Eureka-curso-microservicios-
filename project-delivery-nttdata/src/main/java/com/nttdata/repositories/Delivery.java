package com.nttdata.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad: T_DELIVERY
 * 
 * @author NTT DATA
 *
 */
@Entity
@Table(name = "T_DELIVERY")
public class Delivery extends AbstractEntity implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** ID del pedido (PK) */
	private Long deliveryId;

	/** Código del pedido */
	private String code;

	/** Cliente asociado (FK N-1) */
	private Customer customer;

	/** Productos asociados (N-M) */
	private List<Product> products;

	/**
	 * @return the deliveryId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID_PK")
	public Long getDeliveryId() {
		return deliveryId;
	}

	/**
	 * @param deliveryId
	 *            the deliveryId to set
	 */
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	/**
	 * @return the code
	 */
	@Column(name = "C_CODE", unique = true, nullable = false)
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the customer
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_CUSTOMER_FK")
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the products
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "T_DELIVERY_PRODUCT", joinColumns = { @JoinColumn(name = "C_DELIVERY_FK") }, inverseJoinColumns = { @JoinColumn(name = "C_PRODUCT_FK") })
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
