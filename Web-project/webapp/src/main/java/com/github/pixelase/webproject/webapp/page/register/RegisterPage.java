package com.github.pixelase.webproject.webapp.page.register;

import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.panel.edit.AccountEditPanel;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public class RegisterPage extends BasePage {

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new AccountEditPanel("account-edit-panel"));
    }
}
