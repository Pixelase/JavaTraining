package com.github.pixelase.webproject.webapp.page.common;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BasePage extends WebPage {

	public BasePage() {
		super();
	}

	public BasePage(IModel<?> model) {
		super(model);
	}

	public BasePage(PageParameters parameters) {
		super(parameters);
	}

}
