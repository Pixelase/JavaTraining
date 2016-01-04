package com.github.pixelase.webproject.webapp.page.edit.register;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.webapp.page.edit.common.EditPage;
import com.github.pixelase.webproject.webapp.panel.edit.TenantEditPanel;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public class TenantRegisterPage extends EditPage {

    public TenantRegisterPage() {
        super(new TenantEditPanel(EDIT_PANEL_ID));
    }

    public TenantRegisterPage(Tenant tenant) {
        super(new TenantEditPanel(EDIT_PANEL_ID, tenant));
    }
}
