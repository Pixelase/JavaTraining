package com.github.pixelase.webapp;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pixelase.dataaccess.dao.common.Filter;
import com.github.pixelase.dataaccess.model.Brigade;
import com.github.pixelase.dataaccess.model.BrigadeMember;
import com.github.pixelase.dataaccess.model.Employee;
import com.github.pixelase.dataaccess.model.Tenant;
import com.github.pixelase.services.AddressService;
import com.github.pixelase.services.BrigadeMemberService;
import com.github.pixelase.services.BrigadeService;
import com.github.pixelase.services.EmployeeService;
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

		Tenant save = tenantService.save(new Tenant("23sdfs", "Bzevich", null));
		Tenant save1 = tenantService.save(new Tenant("23sdfs", "Bzevich", null));
		Tenant save2 = tenantService.save(new Tenant("23sdfs", "Bzevich", null));
		// tenantService.registerTenant("Ivan", "Noviy", 123);
		// System.out.println(save.getId());
		// tenantService.delete(new Tenant(33, "Vanko1", "Bzevich", null));

		tenantService.deleteAll();
		System.out.println(tenantService.findAll(new Filter.Builder().add("last_name", "Bzevich").build()));
		// System.out.println(tenantService.findAll());
		// System.out.println(addressService.findAll());
	}
}
