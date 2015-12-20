package com.github.pixelase.webproject.webapp.panel.layout.header;

import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
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

        add(new BookmarkablePageLink<Void>("profile-page-link", ProfilePage.class));

        add(new Link("sign-out-link") {

            @Override
            public void onClick() {
                BasicAuthenticationSession.get().signOut();
                setResponsePage(getPage());

            }

        });
    }
}
