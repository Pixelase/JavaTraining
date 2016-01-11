package com.github.pixelase.webproject.webapp.panel.view.card;

import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.webapp.page.edit.register.TenantRegisterPage;
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
        roles = RoleUtils.TENANT_ROLE)
public class TenantCardPanel extends Panel {

    public static final String STREET_TEXT_ID = "street-text";
    public static final String HOUSE_TEXT_ID = "house-text";
    public static final String APARTMENT_TEXT_ID = "apartment-text";
    public static final String EDIT_INFO_BUTTON_ID = "edit-info-button";

    private final Tenant tenant;

    public TenantCardPanel(final String id, final Tenant tenant) {
        super(id);
        this.tenant = tenant;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        final Address address = (tenant.getAddress() != null) ?
                tenant.getAddress() : new Address();

        add(new Label(STREET_TEXT_ID, address.getStreet()));
        add(new Label(HOUSE_TEXT_ID, address.getHouse()));
        add(new Label(APARTMENT_TEXT_ID, address.getApartment()));

        add(new Link<Void>(EDIT_INFO_BUTTON_ID) {
            @Override
            public void onClick() {
                setResponsePage(new TenantRegisterPage(tenant));
            }
        });
    }
}
