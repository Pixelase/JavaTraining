package com.github.pixelase.webproject.webapp.panel.layout.header;

import com.github.pixelase.webproject.webapp.page.signin.SignInPage;
import com.github.pixelase.webproject.webapp.page.register.RegisterPage;
import com.github.pixelase.webproject.webapp.panel.layout.common.HeaderPanel;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * Created by Alexander Babai on 20.12.2015.
 */
public class HeaderPanelForAnonymousUser extends HeaderPanel {
    public HeaderPanelForAnonymousUser(String id) {
        super(id);

        add(new BookmarkablePageLink<Void>("sign-in-page-link", SignInPage.class));
        add(new BookmarkablePageLink<Void>("register-page-link", RegisterPage.class));
    }
}
