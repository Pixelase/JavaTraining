package com.github.pixelase.webproject.webapp.page.edit.register;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.webapp.page.edit.common.EditPage;
import com.github.pixelase.webproject.webapp.panel.edit.AccountEditPanel;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public class AccountRegisterPage extends EditPage {

    public AccountRegisterPage() {
        super(new AccountEditPanel(EDIT_PANEL_ID));
    }

    public AccountRegisterPage(Account account) {
        super(new AccountEditPanel(EDIT_PANEL_ID, account));
    }
}
