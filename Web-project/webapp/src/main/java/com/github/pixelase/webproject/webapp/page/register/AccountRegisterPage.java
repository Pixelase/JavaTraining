package com.github.pixelase.webproject.webapp.page.register;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.webapp.page.register.common.RegisterPage;
import com.github.pixelase.webproject.webapp.panel.edit.AccountEditPanel;
import org.apache.wicket.MetaDataKey;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public class AccountRegisterPage extends RegisterPage {


    public static final MetaDataKey<Account> TEMP_ACCOUNT_KEY = new MetaDataKey<Account>() {
    };

    public AccountRegisterPage() {
        super(new AccountEditPanel(EDIT_PANEL_ID));
    }
}
