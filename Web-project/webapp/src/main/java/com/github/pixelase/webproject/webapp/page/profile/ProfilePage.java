package com.github.pixelase.webproject.webapp.page.profile;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.services.AccountService;
import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.panel.view.card.AccountCardPanel;
import com.github.pixelase.webproject.webapp.panel.view.card.EmployeeCardPanel;
import com.github.pixelase.webproject.webapp.panel.view.card.TenantCardPanel;
import com.github.pixelase.webproject.webapp.utils.RoleUtils;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Alexander Babai on 21.12.2015.
 */

@AuthorizeInstantiation(value = {RoleUtils.TENANT_ROLE, RoleUtils.EMPLOYEE_ROLE})
public class ProfilePage extends BasePage {

    public static final String ACCOUNT_CARD_PANEL_ID = "account-card-panel";
    public static final String TENANT_CARD_PANEL_ID = "tenant-card-panel";
    public static final String EMPLOYEE_CARD_PANEL_ID = "employee-card-panel";

    @SpringBean
    private AccountService accountService;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        final Integer accountId = BasicAuthenticationSession.get().getMetaData(BasicAuthenticationSession.ACCOUNT_ID_KEY);
        final Account account = (accountService.findOne(accountId) != null) ?
                accountService.findOne(accountId) : new Account(accountId);
        final Tenant tenant = (account.getTenant() != null) ?
                account.getTenant() : new Tenant();
        final Employee employee = (account.getEmployee() != null) ?
                account.getEmployee() : new Employee();

        add(new AccountCardPanel(ACCOUNT_CARD_PANEL_ID, account));
        add(new TenantCardPanel(TENANT_CARD_PANEL_ID, tenant));
        add(new EmployeeCardPanel(EMPLOYEE_CARD_PANEL_ID, employee));

    }
}
