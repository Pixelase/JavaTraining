package com.github.pixelase.webapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pixelase.services.TenantService;

public class MainPage {
	private static ApplicationContext aContext;

	public static void main(String[] args) {

		aContext = new ClassPathXmlApplicationContext("spring-context.xml");

		TenantService tenantService = aContext.getBean(TenantService.class);
		tenantService.registerTenant("Ivan", "Ivanov");

		System.out.println(tenantService.getById(1l));
	}
}
