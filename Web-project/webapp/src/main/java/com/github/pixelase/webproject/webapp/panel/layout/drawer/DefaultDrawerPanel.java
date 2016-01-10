package com.github.pixelase.webproject.webapp.panel.layout.drawer;

import com.github.pixelase.webproject.webapp.page.edit.request.CreateRequestPage;
import com.github.pixelase.webproject.webapp.page.view.many.BrigadesPage;
import com.github.pixelase.webproject.webapp.page.view.many.RequestsPage;
import com.github.pixelase.webproject.webapp.panel.layout.common.DrawerPanel;
import com.github.pixelase.webproject.webapp.utils.RoleUtils;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.link.Link;

public class DefaultDrawerPanel extends DrawerPanel {

    public static final String CREATE_REQUEST_PAGE_LINK_ID = "create-request-page-link";
    public static final String REQUESTS_PAGE_LINK_ID = "requests-page-link";
    public static final String BRIGADES_PAGE_LINK_ID = "brigades-page-link";
    public static final String COMMON_LINK_ID = "common-link";

    public DefaultDrawerPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new CreateRequestLink(CREATE_REQUEST_PAGE_LINK_ID));
        add(new RequestsPageLink(REQUESTS_PAGE_LINK_ID));
        add(new BrigadesPageLink(BRIGADES_PAGE_LINK_ID));
        add(new Link<Void>(COMMON_LINK_ID) {
            @Override
            public void onClick() {

            }
        });
    }

    @AuthorizeAction(roles = RoleUtils.TENANT_ROLE, action = Action.RENDER)
    private static class CreateRequestLink extends Link<Void> {

        public CreateRequestLink(String id) {
            super(id);
        }

        @Override
        public void onClick() {
            setResponsePage(CreateRequestPage.class);
        }
    }

    @AuthorizeAction(roles = RoleUtils.TENANT_ROLE, action = Action.RENDER)
    private static class RequestsPageLink extends Link<Void> {
        public RequestsPageLink(String id) {
            super(id);
        }

        @Override
        public void onClick() {
            setResponsePage(RequestsPage.class);
        }
    }

    @AuthorizeAction(roles = RoleUtils.EMPLOYEE_ROLE, action = Action.RENDER)
    private static class BrigadesPageLink extends Link<Void> {
        public BrigadesPageLink(String id) {
            super(id);
        }

        @Override
        public void onClick() {
            setResponsePage(BrigadesPage.class);
        }
    }
}
