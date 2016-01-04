package com.github.pixelase.webproject.webapp.panel.edit;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.services.AccountService;
import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.profile.ProfilePage;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;

/**
 * Created by Alexander Babai on 04.01.2016.
 */
public class SignInEditPanel extends EditPanel {

    public static final String LOGIN_TEXT_FIELD_ID = "login";
    public static final String PASSWORD_TEXT_FIELD_ID = "password";
    public static final String SUBMIT_BUTTON_ID = "submitButton";

    @SpringBean
    private AccountService accountService;

    public SignInEditPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        final TextField<String> loginTextField = new TextField<>(LOGIN_TEXT_FIELD_ID, Model.of(""));
        loginTextField.setRequired(true);
        loginTextField.setOutputMarkupId(true);
        loginTextField.add(StringValidator.lengthBetween(3, 20));
        form.add(loginTextField);

        final PasswordTextField passwordTextField = new PasswordTextField(PASSWORD_TEXT_FIELD_ID, Model.of(""));
        passwordTextField.setRequired(true);
        passwordTextField.add(StringValidator.minimumLength(5));
        passwordTextField.setOutputMarkupId(true);
        form.add(passwordTextField);


        form.add(new Button(SUBMIT_BUTTON_ID) {
            @Override
            public void onSubmit() {
                super.onSubmit();

                final String login = loginTextField.getModelObject();
                final String password = passwordTextField.getModelObject();

                final AuthenticatedWebSession session = BasicAuthenticationSession.get();
                final boolean isSuccess = session.signIn(login, password);

                if (isSuccess) {
                    setResponsePage(ProfilePage.class);
                    final Account loggedAccount = accountService.findOneByLogin(login);
                    session.setMetaData(BasicAuthenticationSession.LOGGED_ACCOUNT_KEY, loggedAccount);
                } else {
                    error("Incorrect login or password");
                    setResponsePage(getPage());
                }

            }
        });
    }
}
