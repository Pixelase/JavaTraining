package com.github.pixelase.webproject.webapp.page.view.many;

import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.panel.view.table.RequestsTablePanel;
import com.github.pixelase.webproject.webapp.utils.RoleUtils;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

/**
 * Created by Alexander Babai on 07.01.2016.
 */
@AuthorizeInstantiation(value = RoleUtils.TENANT_ROLE)
public class RequestsPage extends BasePage {

    public static final String REQUESTS_TABLE_PANEL_ID = "requests-table-panel";

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new RequestsTablePanel(REQUESTS_TABLE_PANEL_ID));
    }
}
