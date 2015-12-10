package com.github.pixelase.webproject.webapp.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.github.pixelase.webproject.services.TenantService;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@SpringBean 	
	TenantService service;
	
	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// TODO Add your page's components here
		System.out.println(service.findAll());

    }
}
