package com.github.pixelase.webproject.webapp.page.base;

import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.panel.layout.common.DrawerPanel;
import com.github.pixelase.webproject.webapp.panel.layout.common.FooterPanel;
import com.github.pixelase.webproject.webapp.panel.layout.common.HeaderPanel;
import com.github.pixelase.webproject.webapp.panel.layout.header.HeaderPanelForAnonymousUser;
import com.github.pixelase.webproject.webapp.panel.layout.header.HeaderPanelForRegisteredUser;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BasePage extends WebPage {


    protected static final String HEADER_PANEL_ID = "headerPanel";
    protected static final String DRAWER_PANEL_ID = "drawerPanel";
    protected static final String FOOTER_PANEL_ID = "footerPanel";

    protected HeaderPanel headerPanel;
    protected DrawerPanel drawerPanel;
    protected FooterPanel footerPanel;

    public BasePage() {
        super();
        initialize();
    }

    public BasePage(PageParameters parameters) {
        super(parameters);
        initialize();
    }

    private void initialize() {
        if (BasicAuthenticationSession.get().isSignedIn()) {
            headerPanel = new HeaderPanelForRegisteredUser(HEADER_PANEL_ID);
        } else {
            headerPanel = new HeaderPanelForAnonymousUser(HEADER_PANEL_ID);
        }

        drawerPanel = new DrawerPanel(DRAWER_PANEL_ID);
        footerPanel = new FooterPanel(FOOTER_PANEL_ID);

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
