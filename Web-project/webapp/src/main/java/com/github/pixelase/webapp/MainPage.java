package com.github.pixelase.webapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pixelase.dataaccess.dao.common.Filter;
import com.github.pixelase.dataaccess.model.Tenant;
import com.github.pixelase.services.AddressService;
import com.github.pixelase.services.TenantService;

public class MainPage {
	private static ApplicationContext aContext;

	public static void main(String[] args) {

		aContext = new ClassPathXmlApplicationContext("spring-context.xml");

		TenantService tenantService = aContext.getBean(TenantService.class);
		AddressService addressService = aContext.getBean(AddressService.class);
		// Address address1 = new Address("Green", "23", "56a");
		// Address address2 = new Address("Кленовая", "23", "22");
		// addressService.save(address1);
		// addressService.save(address2);

		Tenant save = tenantService.save(new Tenant("Ivan", "Ivanov", null));
		// tenantService.registerTenant("Ivan", "Noviy", 123);
		// System.out.println(save.getId());

//		tenantService.deleteAll();
		System.out.println(tenantService.findAll(new Filter.Builder().add("last_name", "Ivanov").build()));
		// System.out.println(tenantService.findAll());
		// System.out.println(addressService.findAll());
	}
}
