package com.github.pixelase.webproject.webapp.panel.view.card;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.webapp.page.view.one.BrigadeViewPage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by Alexander Babai on 09.01.2016.
 */
public class RequestCardPanel extends Panel {

    public static final String ID_TEXT_ID = "id-text";
    public static final String WORK_SCOPE_TEXT_ID = "work-scope-text";
    public static final String WORK_TYPE_TEXT_ID = "work-type-text";
    public static final String DESIRED_DATE_TEXT_ID = "desired-date-text";
    public static final String BRIGADE_TEXT_ID = "brigade-text";
    public static final String GO_BACK_BUTTON_ID = "go-back-button";
    public static final String OPEN_BRIGADE_BUTTON_ID = "open-brigade-button";

    public RequestCardPanel(String id, WorkRequest request) {
        super(id);

        final WorkScope workScope = (request.getWorkScope() != null) ?
                request.getWorkScope() : new WorkScope();
        final WorkType workType = (request.getWorkType() != null) ?
                request.getWorkType() : new WorkType();
        final Brigade brigade = (request.getBrigade() != null) ?
                request.getBrigade() : new Brigade();


        final Label idText = new Label(ID_TEXT_ID, request.getId());
        final Label workScopeText = new Label(WORK_SCOPE_TEXT_ID, String.format("%s %s, %s %s",
                getString("request_card_panel_w_scope_name"), workScope.getName(),
                getString("request_card_panel_empl_count"), workScope.getEmployeesCount()));
        final Label workTypeText = new Label(WORK_TYPE_TEXT_ID, workType.getName());
        final Label desiredDateText = new Label(DESIRED_DATE_TEXT_ID, request.getDesiredDate());
        final Label brigadeText = new Label(BRIGADE_TEXT_ID, brigade.getId());
        final Link<Void> openBrigadeButton = new Link<Void>(OPEN_BRIGADE_BUTTON_ID) {
            @Override
            public void onClick() {
                setResponsePage(new BrigadeViewPage(brigade));
            }
        };
        final AjaxLink<Void> goBackButton = new AjaxLink<Void>(GO_BACK_BUTTON_ID) {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.appendJavaScript("window.history.back()");
            }
        };

        if (brigade.isNew()) {
            openBrigadeButton.setVisible(false);
        }

        openBrigadeButton.add(brigadeText);
        add(idText);
        add(workScopeText);
        add(workTypeText);
        add(desiredDateText);
        add(openBrigadeButton);
        add(goBackButton);
    }
}
