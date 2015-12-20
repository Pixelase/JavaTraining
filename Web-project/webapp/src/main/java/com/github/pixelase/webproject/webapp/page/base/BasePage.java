package com.github.pixelase.webproject.webapp.page.base;

import com.github.pixelase.webproject.webapp.panel.layout.common.DrawerPanel;
import com.github.pixelase.webproject.webapp.panel.layout.common.FooterPanel;
import com.github.pixelase.webproject.webapp.panel.layout.common.HeaderPanel;
import com.github.pixelase.webproject.webapp.panel.layout.header.HeaderPanelForAnonymousUser;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BasePage extends WebPage {

    protected final HeaderPanel headerPanel = new HeaderPanelForAnonymousUser("headerPanel");
    protected final DrawerPanel drawerPanel = new DrawerPanel("drawerPanel");
    protected final FooterPanel footerPanel = new FooterPanel("footerPanel");

    public BasePage() {
        super();
        initialize();
    }

    public BasePage(PageParameters parameters) {
        super(parameters);
        initialize();
    }

    private void initialize() {
        add(headerPanel);
        add(drawerPanel);
        add(footerPanel);
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
