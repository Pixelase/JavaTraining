package com.github.pixelase.webproject.webapp.panel.view.card;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.webapp.page.view.one.RequestViewPage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by Alexander Babai on 10.01.2016.
 */
public class BrigadeCardPanel extends Panel {
    public static final String ID_TEXT_ID = "id-text";
    public static final String WORK_REQUEST_TEXT_ID = "work-request-text";
    public static final String REAL_DATE_TEXT_ID = "real-date-text";
    public static final String EMPLOYEES_COUNT_TEXT_ID = "employees-count-text";
    public static final String GO_BACK_BUTTON_ID = "go-back-button";
    public static final String OPEN_REQUEST_BUTTON_ID = "open-request-button";

    private final Brigade brigade;

    public BrigadeCardPanel(final String id, final Brigade brigade) {
        super(id);
        this.brigade = brigade;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        final WorkRequest request = (brigade.getWorkRequest() != null) ?
                brigade.getWorkRequest() : new WorkRequest();

        final Label idText = new Label(ID_TEXT_ID, brigade.getId());
        final Label requestText = new Label(WORK_REQUEST_TEXT_ID, request.getId());
        final Label realDateText = new Label(REAL_DATE_TEXT_ID, brigade.getRealDate());
        final Label employeesCountText = new Label(EMPLOYEES_COUNT_TEXT_ID, brigade.getEmployees().size());
        final Link<Void> openRequestButton = new Link<Void>(OPEN_REQUEST_BUTTON_ID) {
            @Override
            public void onClick() {
                setResponsePage(new RequestViewPage(request));
            }
        };
        final AjaxLink<Void> goBackButton = new AjaxLink<Void>(GO_BACK_BUTTON_ID) {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.appendJavaScript("window.history.back()");
            }
        };

        if (request.isNew()) {
            openRequestButton.setVisible(false);
        }

        openRequestButton.add(requestText);
        add(idText);
        add(realDateText);
        add(employeesCountText);
        add(openRequestButton);
        add(goBackButton);
    }
}
