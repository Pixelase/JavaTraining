package com.github.pixelase.webproject.webapp.page.edit.register;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.webapp.page.edit.common.EditPage;
import com.github.pixelase.webproject.webapp.panel.edit.TenantEditPanel;
import com.github.pixelase.webproject.webapp.utils.RoleUtils;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
@AuthorizeInstantiation(value = {RoleUtils.TENANT_ROLE})
public class TenantRegisterPage extends EditPage {

    public TenantRegisterPage() {
        super(new TenantEditPanel(EDIT_PANEL_ID));
        denyAccessForSignedUser();
    }

    public TenantRegisterPage(final Tenant tenant) {
        super(new TenantEditPanel(EDIT_PANEL_ID, tenant));
    }
}
