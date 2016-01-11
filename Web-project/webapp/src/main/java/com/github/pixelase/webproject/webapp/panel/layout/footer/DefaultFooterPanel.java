package com.github.pixelase.webproject.webapp.panel.layout.footer;

import com.github.pixelase.webproject.webapp.page.about.AboutPage;
import com.github.pixelase.webproject.webapp.page.home.HomePage;
import com.github.pixelase.webproject.webapp.panel.layout.common.FooterPanel;
import com.github.pixelase.webproject.webapp.panel.layout.footer.i18n.LanguageSelectionPanel;
import org.apache.wicket.markup.html.link.Link;

public class DefaultFooterPanel extends FooterPanel {

    public static final String HOME_PAGE_LINK_ID = "home-page-link";
    public static final String ABOUT_PAGE_LINK_ID = "about-page-link";
    public static final String LANGUAGE_SELECTION_PANEL_ID = "language-selection-panel";

    public DefaultFooterPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Link<Void>(HOME_PAGE_LINK_ID) {
            @Override
            public void onClick() {
                setResponsePage(HomePage.class);
            }
        });

        add(new Link<Void>(ABOUT_PAGE_LINK_ID) {
            @Override
            public void onClick() {
                setResponsePage(AboutPage.class);
            }
        });

        add(new LanguageSelectionPanel(LANGUAGE_SELECTION_PANEL_ID));
    }
}
