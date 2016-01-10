package com.github.pixelase.webproject.webapp.panel.edit;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.services.AddressService;
import com.github.pixelase.webproject.services.TenantService;
import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.edit.register.RegisterCompletePage;
import com.github.pixelase.webproject.webapp.page.profile.ProfilePage;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class TenantEditPanel extends EditPanel<Tenant> {

    public static final String STREET_TEXT_FIELD_ID = "street";
    public static final String HOUSE_TEXT_FIELD_ID = "house";
    public static final String APARTMENT_TEXT_FIELD_ID = "apartment";
    public static final String SUBMIT_BUTTON_ID = "submitButton";
    public static final String RESET_BUTTON_ID = "resetButton";
    public static final String TENANT_EDIT_PANEL_CSS_CLASS = "tenant-edit-panel";

    @SpringBean
    private AddressService addressService;

    @SpringBean
    private TenantService tenantService;

    public TenantEditPanel(String id) {
        super(id, new Tenant());
    }

    public TenantEditPanel(String id, Tenant tenant) {
        super(id, tenant);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        appendCssClass(TENANT_EDIT_PANEL_CSS_CLASS);

        if (form.getModelObject().getAddress() == null) {
            form.getModelObject().setAddress(new Address());
        }
        final Address address = form.getModelObject().getAddress();

        final TextField<String> streetTextField = new TextField<String>(STREET_TEXT_FIELD_ID,
                new PropertyModel<String>(address, STREET_TEXT_FIELD_ID));
        streetTextField.setOutputMarkupId(true);
        form.add(streetTextField);

        final TextField<String> houseTextField = new TextField<String>(HOUSE_TEXT_FIELD_ID,
                new PropertyModel<String>(address, HOUSE_TEXT_FIELD_ID));
        houseTextField.setOutputMarkupId(true);
        form.add(houseTextField);

        final TextField<String> apartmentTextField = new TextField<String>(APARTMENT_TEXT_FIELD_ID,
                new PropertyModel<String>(address, APARTMENT_TEXT_FIELD_ID));

        apartmentTextField.setOutputMarkupId(true);
        form.add(apartmentTextField);

        form.add(new Button(SUBMIT_BUTTON_ID) {
            @Override
            public void onSubmit() {
                super.onSubmit();

                final Tenant tenant = form.getModelObject();

                if (getPage().wasCreatedBookmarkable()) {
                    final AuthenticatedWebSession session = BasicAuthenticationSession.get();

                    final Integer accountId = session.getMetaData(BasicAuthenticationSession.ACCOUNT_ID_KEY);
                    final Account account = new Account(accountId);
                    final Address savedAddress = addressService.save(address);

                    tenant.setAccount(account);
                    tenant.setAddress(savedAddress);

                    setResponsePage(RegisterCompletePage.class);

                    //Clear metadata when registration is complete
                    session.setMetaData(BasicAuthenticationSession.ACCOUNT_ID_KEY, null);
                } else {
                    //TODO setResponsePage in other situations
                    setResponsePage(ProfilePage.class);//Temporary solution
                }

                tenantService.save(tenant);
            }
        });

        form.add(new ResetFormLink(RESET_BUTTON_ID));
    }
}
