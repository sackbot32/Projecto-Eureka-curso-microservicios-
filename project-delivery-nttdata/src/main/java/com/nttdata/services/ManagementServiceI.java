package com.nttdata.services;

import java.util.List;

import com.nttdata.repositories.Customer;
import com.nttdata.repositories.Delivery;
import com.nttdata.repositories.Product;

/**
 * Servicio de gestión de la mensajería.
 * 
 * @author NTT DATA
 *
 */
public interface ManagementServiceI {

	/**
	 * Genera un pedido.
	 * 
	 * @param d
	 * @return Delivery
	 */
	public Delivery addDelivery(Delivery d);

	/**
	 * Añade clientes.
	 * 
	 * @param c
	 * @return Customer
	 */
	public Customer addCustomer(Customer c);

	/**
	 * Añade productos.
	 * 
	 * @param p
	 * @return Product
	 */
	public Product addProduct(Product p);

	/**
	 * Obtiene todos los clientes.
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> getAllCustomers();

	/**
	 * Obtiene todos los pedidos.
	 * 
	 * @return List<Delivery>
	 */
	public List<Delivery> getAllDeliveries();

	/**
	 * Obtiene todos los productos.
	 * 
	 * @return List<Product>
	 */
	public List<Product> getAllProducts();

	/**
	 * Obtiene cliente por documento de identidad.
	 * 
	 * @param identityDoc
	 * @return Customer
	 */
	public Customer getCustomerByIdentityDoc(final String identityDoc);

	/**
	 * Obtiene pedido por código.
	 * 
	 * @param code
	 * @return Delivery
	 */
	public Delivery getDeliveryByCode(final String code);

	/**
	 * Obtiene producto por código.
	 * 
	 * @param code
	 * @return Product
	 */
	public Product getProductByCode(final String code);

	/**
	 * Desglosa un pedido buscado.
	 * 
	 * @param code
	 * @return DeliveryDataDto
	 */
	public DeliveryDataDto showDeliveryFullDataByCode(final String code);

	/**
	 * Obtención de pedidos por patrón en nombre de cliente.
	 * 
	 * @param namePattern
	 * @return List<Delivery>
	 */
	public List<Delivery> searchDeliveriesByCustomerNamePattern(final String namePattern);
}
