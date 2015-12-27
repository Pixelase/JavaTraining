package com.github.pixelase.webproject.webapp.page.register.common;

import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public abstract class RegisterPage extends BasePage {

    public static final String EDIT_PANEL_ID = "edit-panel";

    protected final EditPanel<?> editPanel;

    public RegisterPage(EditPanel<?> editPanel) {
        this.editPanel = editPanel;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(editPanel);
    }
}
