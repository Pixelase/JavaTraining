package com.github.pixelase.webproject.webapp.panel.layout.header;

import com.github.pixelase.webproject.webapp.page.register.AccountRegisterPage;
import com.github.pixelase.webproject.webapp.page.signin.SignInPage;
import com.github.pixelase.webproject.webapp.panel.layout.common.HeaderPanel;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * Created by Alexander Babai on 20.12.2015.
 */
public class HeaderPanelForAnonymousUser extends HeaderPanel {

    public static final String SIGN_IN_PAGE_LINK_ID = "sign-in-page-link";
    public static final String REGISTER_PAGE_LINK_ID = "register-page-link";
    public static final String SMALL_SIGN_IN_PAGE_LINK_ID = "small-sign-in-page-link";
    public static final String SMALL_REGISTER_PAGE_LINK_ID = "small-register-page-link";

    public HeaderPanelForAnonymousUser(String id) {
        super(id);

        //For large screens
        add(new BookmarkablePageLink<Void>(SIGN_IN_PAGE_LINK_ID, SignInPage.class));
        add(new BookmarkablePageLink<Void>(REGISTER_PAGE_LINK_ID, AccountRegisterPage.class));

        //For small screens
        add(new BookmarkablePageLink<Void>(SMALL_SIGN_IN_PAGE_LINK_ID, SignInPage.class));
        add(new BookmarkablePageLink<Void>(SMALL_REGISTER_PAGE_LINK_ID, AccountRegisterPage.class));
    }
}
