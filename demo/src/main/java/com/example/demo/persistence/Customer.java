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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer extends AbstractEntity implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id_pk;
	
	private String name;

	private long identityDoc;
	
	private String address;
 
	private List<Delivery> deliveries;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID_PK")
	public long getId_pk() {
		return id_pk;
	}

	public void setId_pk(long id_pk) {
		this.id_pk = id_pk;
	}
	@Column(name = "C_NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Column(name = "C_ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	public List<Delivery> getDeliveries() {
		return deliveries;
	}
	
	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public long getIdentityDoc() {
		return identityDoc;
	}
	@Column(name = "C_IDENTITY_DOC", unique = true, nullable = false)
	public void setIdentityDoc(long identityDoc) {
		this.identityDoc = identityDoc;
	}

	@Override
	public String toString() {
		return "Customer [id_pk=" + id_pk + ", name=" + name + ", identityDoc=" + identityDoc + ", address=" + address
				+ ", deliveries=" + deliveries + "]";
	}
	
	
}

