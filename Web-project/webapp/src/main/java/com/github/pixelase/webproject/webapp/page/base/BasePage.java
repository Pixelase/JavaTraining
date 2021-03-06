package com.github.pixelase.webproject.webapp.page.base;

import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.panel.layout.common.DrawerPanel;
import com.github.pixelase.webproject.webapp.panel.layout.common.FooterPanel;
import com.github.pixelase.webproject.webapp.panel.layout.common.HeaderPanel;
import com.github.pixelase.webproject.webapp.panel.layout.drawer.DefaultDrawerPanel;
import com.github.pixelase.webproject.webapp.panel.layout.footer.DefaultFooterPanel;
import com.github.pixelase.webproject.webapp.panel.layout.header.HeaderPanelForAnonymousUser;
import com.github.pixelase.webproject.webapp.panel.layout.header.HeaderPanelForRegisteredUser;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public abstract class BasePage extends WebPage {

    public static final String HEADER_PANEL_ID = "header-panel";
    public static final String DRAWER_PANEL_ID = "drawer-panel";
    public static final String FOOTER_PANEL_ID = "footer-panel";

    protected HeaderPanel headerPanel;
    protected DrawerPanel drawerPanel;
    protected FooterPanel footerPanel;

    public BasePage() {
        super();
    }

    public BasePage(final PageParameters parameters) {
        super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        if (BasicAuthenticationSession.get().isSignedIn()) {
            headerPanel = new HeaderPanelForRegisteredUser(HEADER_PANEL_ID);
        } else {
            headerPanel = new HeaderPanelForAnonymousUser(HEADER_PANEL_ID);
        }

        drawerPanel = new DefaultDrawerPanel(DRAWER_PANEL_ID);
        footerPanel = new DefaultFooterPanel(FOOTER_PANEL_ID);

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
