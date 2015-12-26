package com.github.pixelase.webproject.webapp.panel.edit;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;

public class TenantEditPanel extends EditPanel<Tenant> {

    public TenantEditPanel(String id) {
        super(id);
    }

    @Override
    protected Tenant getModelObject() {
        return null;
    }

}
