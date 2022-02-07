package com.nttdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.repositories.Customer;
import com.nttdata.repositories.Delivery;
import com.nttdata.repositories.Product;
import com.nttdata.services.DeliveryDataDto;
import com.nttdata.services.ManagementServiceI;

/**
 * Aplicación de gestión de pedidos.
 * 
 * @author NTT DATA
 *
 */
@SpringBootApplication
public class ProyectoNttDataApplication implements CommandLineRunner {

	/** Inyección de servicio de gestión de mensajería */
	@Autowired
	private ManagementServiceI managementService;

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Ejecución de la aplicación.
		SpringApplication.run(ProyectoNttDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Constantes de auditoría.
		final Date AUDIT_DATE = new Date();
		final String AUDIT_USER = "SystemNTTData";

		Customer c1 = new Customer();
		c1.setIdentityDoc("10998877A");
		c1.setName("Alejandro Téllez");
		c1.setAddress("Sevilla - C/Macarena N1 1A");
		c1.setUpdateDate(AUDIT_DATE);
		c1.setUpdateUser(AUDIT_USER);

		List<Product> productsList1 = new ArrayList<Product>();

		Product pr1 = new Product();
		pr1.setCode("PR01");
		pr1.setName("Sony PlayStation 5 - Digital");
		pr1.setPrice(400f);
		pr1.setUpdateDate(AUDIT_DATE);
		pr1.setUpdateUser(AUDIT_USER);

		productsList1.add(pr1);

		Product pr2 = new Product();
		pr2.setCode("PR02");
		pr2.setName("Sony Auriculares Pulse 3D");
		pr2.setPrice(80f);
		pr2.setUpdateDate(AUDIT_DATE);
		pr2.setUpdateUser(AUDIT_USER);

		productsList1.add(pr2);

		Delivery d1 = new Delivery();
		d1.setCode("PED01");
		d1.setCustomer(c1);
		d1.setUpdateDate(AUDIT_DATE);
		d1.setUpdateUser(AUDIT_USER);
		d1.setProducts(productsList1);

		d1 = managementService.addDelivery(d1);

		final DeliveryDataDto deData = managementService.showDeliveryFullDataByCode("PED01");
		System.out.println(deData.toString());

		final List<Delivery> dList = managementService.searchDeliveriesByCustomerNamePattern("A%");
		System.out.println("Número de pedidos por el patrón indicado: " + dList.size());
	}

}
