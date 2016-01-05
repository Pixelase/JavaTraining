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
    public HeaderPanelForRegisteredUser(String id) {
        super(id);

        //For large screens
        add(new BookmarkablePageLink<Void>("profile-page-link", ProfilePage.class));
        add(new SignOutLink("sign-out-link"));

        //For small screens
        add(new BookmarkablePageLink<Void>("small-profile-page-link", ProfilePage.class));
        add(new SignOutLink("small-sign-out-link"));
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
