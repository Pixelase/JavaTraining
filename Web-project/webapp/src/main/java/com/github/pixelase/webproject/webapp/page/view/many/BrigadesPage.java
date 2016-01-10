package com.github.pixelase.webproject.webapp.page.view.many;

import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.panel.view.table.BrigadesTablePanel;
import com.github.pixelase.webproject.webapp.utils.RoleUtils;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

/**
 * Created by Alexander Babai on 10.01.2016.
 */

@AuthorizeInstantiation(value = RoleUtils.EMPLOYEE_ROLE)
public class BrigadesPage extends BasePage {
    public static final String BRIGADES_TABLE_PANEL_ID = "brigades-table-panel";

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new BrigadesTablePanel(BRIGADES_TABLE_PANEL_ID));
    }
}
