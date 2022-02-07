package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.nttdata.repositories.Customer;
import com.nttdata.repositories.CustomerRepositoryI;
import com.nttdata.repositories.Delivery;
import com.nttdata.repositories.DeliveryRepository;
import com.nttdata.repositories.Product;
import com.nttdata.repositories.ProductRepositoryI;

/**
 * Servicio de gestión de la mensajería.
 * 
 * @author NTT DATA
 *
 */
@Service
public class ManagementServiceImpl implements ManagementServiceI {

	/** Repositorio: T_CUSTOMER */
	@Autowired
	private CustomerRepositoryI customerRepo;

	/** Repositorio: T_DELIVERY */
	@Autowired
	private DeliveryRepository deliveryRepo;

	/** Repositorio: T_PRODUCT */
	@Autowired
	private ProductRepositoryI productRepo;

	@Override
	public Customer addCustomer(Customer c) {

		// Verificación de nulidad.
		if (c != null && StringUtils.isNotBlank(c.getIdentityDoc()) && c.getCustomerId() == null && StringUtils.isNotBlank(c.getName())
		        && StringUtils.isNotBlank(c.getAddress())) {

			c = customerRepo.save(c);

		} else {
			System.out.println("[ERROR] ID de pedido informado o información relevante errónea.");
		}

		return c;
	}

	@Override
	public Delivery addDelivery(Delivery d) {

		// Verificación de nulidad.
		if (d != null && StringUtils.isNotBlank(d.getCode()) && d.getDeliveryId() == null) {

			d = deliveryRepo.save(d);

		} else {
			System.out.println("[ERROR] ID de pedido informado o código vacío.");
		}

		return d;

	}

	@Override
	public Product addProduct(Product p) {

		// Verificación de nulidad.
		if (p != null && StringUtils.isNotBlank(p.getCode()) && p.getProductId() == null) {

			p = productRepo.save(p);

		} else {
			System.out.println("[ERROR] ID de producto informado o código vacío.");
		}

		return p;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public List<Delivery> getAllDeliveries() {
		return deliveryRepo.findAll();
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Customer getCustomerByIdentityDoc(String identityDoc) {
		return customerRepo.findByIdentityDoc(identityDoc);
	}

	@Override
	public Delivery getDeliveryByCode(String code) {
		return deliveryRepo.findByCode(code);
	}

	@Override
	public Product getProductByCode(String code) {
		return productRepo.findByCode(code);
	}

	@Override
	public DeliveryDataDto showDeliveryFullDataByCode(final String code) {

		// Resultado.
		DeliveryDataDto result = new DeliveryDataDto();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(code)) {

			// Obtención del pedido.
			final Delivery d = deliveryRepo.findByCode(code);

			// Verificación de nulidad.
			if (d != null) {

				// Información del desglose.
				result.setDeliveryCode(d.getCode());

				// Información el cliente.
				if (d.getCustomer() != null) {
					result.setCustomerName(d.getCustomer().getName());
					result.setAddress(d.getCustomer().getAddress());
				}

				// Información de los productos.
				if (!CollectionUtils.isEmpty(d.getProducts())) {
					result.setTotalPrice(0);
					final List<String> productsDetails = new ArrayList<String>();
					for (final Product p : d.getProducts()) {
						productsDetails.add(p.getCode() + " - " + p.getPrice() + "€");
						result.setTotalPrice(result.getTotalPrice() + p.getPrice());
					}
					result.setProductsDetail(productsDetails);
				}
			}
		}

		return result;
	}

	@Override
	public List<Delivery> searchDeliveriesByCustomerNamePattern(String namePattern) {
		return deliveryRepo.getByCustomerNamePattern(namePattern);
	}

}
