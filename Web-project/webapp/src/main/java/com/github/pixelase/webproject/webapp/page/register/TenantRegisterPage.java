package com.github.pixelase.webproject.webapp.page.register;

import com.github.pixelase.webproject.webapp.page.register.common.RegisterPage;
import com.github.pixelase.webproject.webapp.panel.edit.TenantEditPanel;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public class TenantRegisterPage extends RegisterPage {

    public TenantRegisterPage() {
        super(new TenantEditPanel(EDIT_PANEL_ID));
    }
}
