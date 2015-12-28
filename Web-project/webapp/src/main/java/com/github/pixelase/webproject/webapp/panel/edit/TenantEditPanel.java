package com.github.pixelase.webproject.webapp.panel.edit;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.services.AddressService;
import com.github.pixelase.webproject.services.TenantService;
import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.profile.ProfilePage;
import com.github.pixelase.webproject.webapp.page.register.AccountRegisterPage;
import com.github.pixelase.webproject.webapp.page.register.RegisterCompletePage;
import com.github.pixelase.webproject.webapp.page.register.TenantRegisterPage;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class TenantEditPanel extends EditPanel<Tenant> {

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

        if (form.getModelObject().getAddress() == null) {
            form.getModelObject().setAddress(new Address());
        }
        final Address address = form.getModelObject().getAddress();

        final TextField<String> streetTextField = new TextField<>("street-text-field", Model.of(address.getStreet()));
        streetTextField.setOutputMarkupId(true);
        form.add(streetTextField);

        final TextField<String> houseTextField = new TextField<>("house-text-field", Model.of(address.getHouse()));
        houseTextField.setOutputMarkupId(true);
        form.add(houseTextField);

        final TextField<String> apartmentTextField = new TextField<>("apartment-text-field", Model.of(address.getApartment()));
        apartmentTextField.setOutputMarkupId(true);
        form.add(apartmentTextField);

        form.add(new Button("submit-button") {
            @Override
            public void onSubmit() {
                super.onSubmit();

                final Account account = BasicAuthenticationSession.get().getMetaData(AccountRegisterPage.REGISTERED_ACCOUNT_KEY);
                final Tenant tenant = form.getModelObject();
                final Address savedAddress = addressService.save(address);

                tenant.setAccount(account);
                tenant.setAddress(savedAddress);

                tenantService.save(tenant);

                if (getPage().getPageClass().equals(TenantRegisterPage.class)) {
                    setResponsePage(RegisterCompletePage.class);
                }
                //TODO setResponsePage in other situations
                setResponsePage(ProfilePage.class);
            }
        });
    }
}
