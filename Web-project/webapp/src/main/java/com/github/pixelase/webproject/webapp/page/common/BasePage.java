package com.github.pixelase.webproject.webapp.page.common;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.github.pixelase.webproject.webapp.panel.layout.DrawerPanel;
import com.github.pixelase.webproject.webapp.panel.layout.FooterPanel;
import com.github.pixelase.webproject.webapp.panel.layout.HeaderPanel;

public class BasePage extends WebPage {

	protected final HeaderPanel headerPanel = new HeaderPanel("headerPanel");
	protected final DrawerPanel drawerPanel = new DrawerPanel("drawerPanel");
	protected final FooterPanel footerPanel = new FooterPanel("footerPanel");

	private void initialize() {
		add(headerPanel);
		add(drawerPanel);
		add(footerPanel);
	}

	public BasePage() {
		super();
		initialize();
	}

	public BasePage(PageParameters parameters) {
		super(parameters);
		initialize();
	}

	public HeaderPanel getHeaderPanel() {
		return headerPanel;
	}

	public DrawerPanel getDrawerPanel() {
		return drawerPanel;
	}

	public FooterPanel getFooterPanel() {
		return footerPanel;
	}

}