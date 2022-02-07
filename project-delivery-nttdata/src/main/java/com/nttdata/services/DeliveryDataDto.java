package com.nttdata.services;

import java.util.List;

/**
 * DTO para mostrar información sobre pedido.
 * 
 * @author NTT DATA
 *
 */
public class DeliveryDataDto {

	/** Código de cliente */
	private String deliveryCode;

	/** Nombre de destinatario */
	private String customerName;

	/** Lista de productos (código - precio) */
	private List<String> productsDetail;

	/** Precio total del pedido */
	private float totalPrice;

	/** Dirección de entrega */
	private String address;

	/**
	 * @return the deliveryCode
	 */
	public String getDeliveryCode() {
		return deliveryCode;
	}

	/**
	 * @param deliveryCode
	 *            the deliveryCode to set
	 */
	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the productsDetail
	 */
	public List<String> getProductsDetail() {
		return productsDetail;
	}

	/**
	 * @param productsDetail
	 *            the productsDetail to set
	 */
	public void setProductsDetail(List<String> productsDetail) {
		this.productsDetail = productsDetail;
	}

	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the address
	 */
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

	@Override
	public String toString() {
		return "Código pedido: " + deliveryCode + "\n Cliente: " + customerName + "\n Dirección: " + ", address=" + address + "\n Lista productos:\n"
		        + productsDetail + "\n Precio total: " + totalPrice + "€";
	}

}
