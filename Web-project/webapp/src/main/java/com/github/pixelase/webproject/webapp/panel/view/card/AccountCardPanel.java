package com.github.pixelase.webproject.webapp.panel.view.card;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.webapp.page.edit.register.AccountRegisterPage;
import com.github.pixelase.webproject.webapp.utils.RoleUtils;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by Alexander Babai on 10.01.2016.
 */
@AuthorizeAction(
        action = Action.RENDER,
        roles = {RoleUtils.TENANT_ROLE, RoleUtils.EMPLOYEE_ROLE})
public class AccountCardPanel extends Panel {

    public static final String LOGIN_TEXT_ID = "login-text";
    public static final String EMAIL_TEXT_ID = "email-text";
    public static final String FIRST_NAME_TEXT_ID = "first-name-text";
    public static final String LAST_NAME_TEXT_ID = "last-name-text";
    public static final String BIRTH_DATE_TEXT_ID = "birth-date-text";
    public static final String EDIT_ACCOUNT_BUTTON_ID = "edit-account-button";

    private final Account account;

    public AccountCardPanel(final String id, final Account account) {
        super(id);
        this.account = account;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Label(LOGIN_TEXT_ID, account.getLogin()));
        add(new Label(EMAIL_TEXT_ID, account.getEmail()));
        add(new Label(FIRST_NAME_TEXT_ID, account.getFirstName()));
        add(new Label(LAST_NAME_TEXT_ID, account.getLastName()));
        add(new Label(BIRTH_DATE_TEXT_ID, account.getBirthDate()));
        add(new Link<Void>(EDIT_ACCOUNT_BUTTON_ID) {
            @Override
            public void onClick() {
                setResponsePage(new AccountRegisterPage(account));
            }
        });
    }
}
