package com.github.pixelase.webproject.webapp.page.edit.common;

import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.page.home.HomePage;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;
import com.googlecode.wicket.kendo.ui.panel.KendoFeedbackPanel;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public abstract class EditPage extends BasePage {

    public static final String EDIT_PANEL_ID = "edit-panel";
    public static final String FEED_BACK_PANEL_ID = "feed-back-panel";

    protected final EditPanel<?> editPanel;
    protected final KendoFeedbackPanel feedbackPanel;

    public EditPage(final EditPanel<?> editPanel) {
        this.editPanel = editPanel;
        feedbackPanel = new KendoFeedbackPanel(FEED_BACK_PANEL_ID);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(editPanel);
        add(feedbackPanel);
    }

    protected void denyAccessForSignedUser() {
        if (BasicAuthenticationSession.get().isSignedIn()) {
            setResponsePage(HomePage.class);
        }
    }

    protected void denyAccessForAnonymousUser() {
        if (!BasicAuthenticationSession.get().isSignedIn()) {
            setResponsePage(HomePage.class);
        }
    }
}
