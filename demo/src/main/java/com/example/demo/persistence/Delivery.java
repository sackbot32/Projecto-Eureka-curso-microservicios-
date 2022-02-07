package com.example.demo.persistence;

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

@Entity
@Table(name = "T_DELIVERY")
public class Delivery extends AbstractEntity implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long d_id_pk;
	
	private Customer customer;
	
	private String code;
	
	private List<Product> products;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID_PK")
	public long getD_id_pk() {
		return d_id_pk;
	}

	public void setD_id_pk(long d_id_pk) {
		this.d_id_pk = d_id_pk;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_CUSTOMER_FK")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Column(name = "C_CODE", unique = true, nullable = false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "T_DELIVERY_PRODUCT", joinColumns = { @JoinColumn(name = "C_DELIVERY_FK") }, inverseJoinColumns = { @JoinColumn(name = "C_PRODUCT_FK") })
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Delivery [d_id_pk=" + d_id_pk + ", customer=" + customer.getName() + ", code=" + code + "";
	}

}
