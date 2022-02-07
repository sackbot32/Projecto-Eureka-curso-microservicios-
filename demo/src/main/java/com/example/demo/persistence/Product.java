package com.example.demo.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "T_PRODUCT")
public class Product extends AbstractEntity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long productId;
	
	private String name;
	
	private String code;
	
	private float price;
	
	private List<Delivery> deliveries;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID_PK")
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	@Column(name = "C_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "C_CODE", unique = true, nullable = false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	@Column(name = "C_PRICE")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	@ManyToMany(mappedBy = "products")
	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", code=" + code + ", price=" + price;
	}
	

}
