package com.github.pixelase.webproject.webapp.page.register.common;

import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;
import com.googlecode.wicket.kendo.ui.panel.KendoFeedbackPanel;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public abstract class RegisterPage extends BasePage {

    public static final String EDIT_PANEL_ID = "edit-panel";
    public static final String FEED_BACK_PANEL_ID = "feed-back-panel";

    protected final EditPanel<?> editPanel;
    protected final KendoFeedbackPanel feedbackPanel;

    public RegisterPage(EditPanel<?> editPanel) {
        this.editPanel = editPanel;
        feedbackPanel = new KendoFeedbackPanel(FEED_BACK_PANEL_ID);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(editPanel);
        add(feedbackPanel);
    }
}
