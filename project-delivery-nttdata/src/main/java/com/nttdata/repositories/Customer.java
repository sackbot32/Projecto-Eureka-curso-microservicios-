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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidad: T_CUSTOMER
 * 
 * @author NTT DATA
 *
 */
@Entity
@Table(name = "T_CUSTOMER")
public class Customer extends AbstractEntity implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** ID del cliente (PK) */
	private Long customerId;

	/** Documento de identidad */
	private String identityDoc;

	/** Nombre */
	private String name;

	/** Dirección */
	private String address;

	/** Lista de pedidos asociados (1-N) */
	private List<Delivery> deliveries;

	/**
	 * @return the customerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID_PK")
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the identityDoc
	 */
	@Column(name = "C_IDENTITY_DOC", unique = true, nullable = false)
	public String getIdentityDoc() {
		return identityDoc;
	}

	/**
	 * @param identityDoc
	 *            the identityDoc to set
	 */
	public void setIdentityDoc(String identityDoc) {
		this.identityDoc = identityDoc;
	}

	/**
	 * @return the name
	 */
	@Column(name = "C_NAME", nullable = false)
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
	 * @return the address
	 */
	@Column(name = "C_ADDRESS")
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the deliveries
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
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
