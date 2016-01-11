package com.github.pixelase.webproject.webapp.panel.layout.header;

import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.home.HomePage;
import com.github.pixelase.webproject.webapp.page.profile.ProfilePage;
import com.github.pixelase.webproject.webapp.panel.layout.common.HeaderPanel;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;

/**
 * Created by Alexander Babai on 20.12.2015.
 */
public class HeaderPanelForRegisteredUser extends HeaderPanel {

    public static final String PROFILE_PAGE_LINK_ID = "profile-page-link";
    public static final String SIGN_OUT_LINK_ID = "sign-out-link";
    public static final String SMALL_PROFILE_PAGE_LINK_ID = "small-profile-page-link";
    public static final String SMALL_SIGN_OUT_LINK_ID = "small-sign-out-link";

    public HeaderPanelForRegisteredUser(String id) {
        super(id);

        //For large screens
        add(new BookmarkablePageLink<Void>(PROFILE_PAGE_LINK_ID, ProfilePage.class));
        add(new SignOutLink(SIGN_OUT_LINK_ID));

        //For small screens
        add(new BookmarkablePageLink<Void>(SMALL_PROFILE_PAGE_LINK_ID, ProfilePage.class));
        add(new SignOutLink(SMALL_SIGN_OUT_LINK_ID));
    }

    private class SignOutLink extends Link<Void> {

        public SignOutLink(String id) {
            super(id);
        }

        @Override
        public void onClick() {
            BasicAuthenticationSession.get().signOut();
            setResponsePage(HomePage.class);
        }
    }
}
