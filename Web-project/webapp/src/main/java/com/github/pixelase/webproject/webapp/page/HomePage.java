package com.github.pixelase.webproject.webapp.page;

import org.apache.wicket.spring.injection.annot.SpringBean;

import com.github.pixelase.webproject.services.TenantService;
import com.github.pixelase.webproject.webapp.page.common.BasePage;

public class HomePage extends BasePage {

	@SpringBean
	TenantService service;

	public HomePage() {
		super();
	}
}
