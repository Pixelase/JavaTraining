package com.github.pixelase.webproject.webapp.page.home;

import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.page.edit.register.AccountRegisterPage;
import org.apache.wicket.markup.html.link.Link;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        final Link<Void> joinButton = new Link<Void>("join-button") {
            @Override
            public void onClick() {
                setResponsePage(AccountRegisterPage.class);
            }
        };

        if (BasicAuthenticationSession.get().isSignedIn()) {
            joinButton.setVisible(false);
        }

        add(joinButton);
    }
}
