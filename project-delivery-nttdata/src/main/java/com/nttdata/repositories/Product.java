package com.nttdata.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entidad: T_PRODUCT
 * 
 * @author NTT DATA
 *
 */
@Entity
@Table(name = "T_PRODUCT")
public class Product extends AbstractEntity implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** ID del producto (PK) */
	private Long productId;

	/** Código del producto */
	private String code;

	/** Nombre del producto */
	private String name;

	/** Precio */
	private Float price;

	/** Listado de pedidos asociados (N-M) */
	private List<Delivery> deliveries;

	/**
	 * @return the productId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID_PK")
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
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
	 * @return the name
	 */
	@Column(name = "C_NAME")
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	@Column(name = "C_PRICE")
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @return the deliveries
	 */
	@ManyToMany(mappedBy = "products")
	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	/**
	 * @param deliveries
	 *            the deliveries to set
	 */
	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

}
