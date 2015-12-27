package com.github.pixelase.webproject.webapp.panel.edit;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;

public class TenantEditPanel extends EditPanel<Tenant> {

    public TenantEditPanel(String id) {
        super(id, new Tenant());
    }

    public TenantEditPanel(String id, Tenant tenant) {
        super(id, tenant);
    }

}
