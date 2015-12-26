package com.github.pixelase.webproject.webapp.panel.edit;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Role;
import com.github.pixelase.webproject.services.AccountService;
import com.github.pixelase.webproject.services.RoleService;
import com.github.pixelase.webproject.webapp.page.register.RegisterPage;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;
import com.googlecode.wicket.kendo.ui.form.datetime.DatePicker;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;
import org.mindrot.jbcrypt.BCrypt;


public class AccountEditPanel extends EditPanel<Account> {

    public static final String LOGIN_ID = "login";
    public static final String EMAIL_ID = "email";
    public static final String CRYPTED_PASSWORD_ID = "cryptedPassword";
    public static final String FIRST_NAME_ID = "firstName";
    public static final String LAST_NAME_ID = "lastName";
    public static final String BIRTH_DATE_ID = "birthDate";
    public static final String RADIO_GROUP_ID = "radioGroup";
    public static final String TENANT_RADIO_BUTTON_ID = "tenantRadioButton";
    public static final String EMPLOYEE_RADIO_BUTTON_ID = "employeeRadioButton";
    public static final String SUBMIT_BUTTON_ID = "submitButton";
    public static final String TENANT_ROLE = "tenant";
    public static final String EMPLOYEE_ROLE = "employee";
    @SpringBean
    AccountService accountService;

    @SpringBean
    RoleService roleService;

    public AccountEditPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        final TextField<String> loginTextField = new TextField<>(LOGIN_ID);
        loginTextField.setRequired(true);
        loginTextField.setOutputMarkupId(true);
        loginTextField.add(StringValidator.lengthBetween(5, 20));
        form.add(loginTextField);

        final TextField<String> emailTextField = new TextField<>(EMAIL_ID);
        emailTextField.setRequired(true);
        emailTextField.setOutputMarkupId(true);
        emailTextField.add(StringValidator.lengthBetween(5, 255));
        emailTextField.add(EmailAddressValidator.getInstance());
        form.add(emailTextField);

        final PasswordTextField passwordTextField = new PasswordTextField(CRYPTED_PASSWORD_ID) {
            @Override
            public void updateModel() {
                setModelObject(BCrypt.hashpw(getConvertedInput(), BCrypt.gensalt()));
            }
        };
        passwordTextField.setRequired(true);
        passwordTextField.add(StringValidator.minimumLength(5));
        passwordTextField.setOutputMarkupId(true);
        form.add(passwordTextField);

        final TextField<String> fNameTextField = new TextField<>(FIRST_NAME_ID);
        fNameTextField.setOutputMarkupId(true);
        form.add(fNameTextField);

        final TextField<String> lNameTextField = new TextField<>(LAST_NAME_ID);
        lNameTextField.setOutputMarkupId(true);
        form.add(lNameTextField);

        final String pattern = "dd.MM.yy";
        final DatePicker datePicker = new DatePicker(BIRTH_DATE_ID, pattern);
        form.add(datePicker);

        final RadioGroup<String> radioGroup = new RadioGroup<>(RADIO_GROUP_ID, Model.of(""));
        final Radio<String> tenantRadioButton = new Radio<>(TENANT_RADIO_BUTTON_ID, Model.of(TENANT_ROLE));
        tenantRadioButton.setOutputMarkupId(true);
        radioGroup.add(tenantRadioButton);

        final Radio<String> employeeRadioButton = new Radio<>(EMPLOYEE_RADIO_BUTTON_ID, Model.of(EMPLOYEE_ROLE));
        employeeRadioButton.setOutputMarkupId(true);
        radioGroup.add(employeeRadioButton);

        if (getPage().getClass().equals(RegisterPage.class)) {
            radioGroup.setVisible(true);
            radioGroup.setRequired(true);
        } else {
            radioGroup.setVisible(false);
            radioGroup.setRequired(false);
        }

        form.add(radioGroup);

        form.add(new Button(SUBMIT_BUTTON_ID) {
            @Override
            public void onSubmit() {
                super.onSubmit();
                Account account = form.getModelObject();
                if (accountService.findOneByLogin(account.getLogin()) == null) {
                    Role role = roleService.findOne(radioGroup.getModelObject());

                    if (role != null) {
                        account.getRoles().add(role);
                    }
                    else {
                        error("Role not found");
                        setResponsePage(getPage().getPageClass());
                    }
                    accountService.save(account);

                    //TODO next registration page;
                    //Use events
                    setResponsePage(getPage().getPageClass());
                } else {
                    //TODO user already registered
                    //May be JS alert
                }
            }
        });
        add(form);


    }

    @Override
    protected Account getModelObject() {
        return new Account();
    }
}
