package com.github.pixelase.webproject.webapp.panel.view.card;

import com.github.pixelase.webproject.dataaccess.model.*;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by Alexander Babai on 09.01.2016.
 */
public class WorkRequestCardWide extends Panel {

    public static final String ID_TEXT_ID = "id-text";
    public static final String WORK_SCOPE_TEXT_ID = "work-scope-text";
    public static final String WORK_TYPE_TEXT_ID = "work-type-text";
    public static final String DESIRED_DATE_TEXT_ID = "desired-date-text";
    public static final String BRIGADE_TEXT_ID = "brigade-text";
    public static final String GO_BACK_BUTTON_ID = "go-back-button";
    private final WorkRequest request;

    public WorkRequestCardWide(String id, WorkRequest request) {
        super(id);
        this.request = request;


        final Label idText = new Label(ID_TEXT_ID, request.getId());

        final WorkScope workScope = (request.getWorkScope() != null) ?
                request.getWorkScope() : new WorkScope();
        final Label workScopeText = new Label(WORK_SCOPE_TEXT_ID, String.format("work scope name: %s, employee count: %s",
                workScope.getName(), workScope.getEmployeesCount()));

        final WorkType workType = (request.getWorkType() != null) ?
                request.getWorkType() : new WorkType();
        final Label workTypeText = new Label(WORK_TYPE_TEXT_ID, workType.getName());
        final Label desiredDateText = new Label(DESIRED_DATE_TEXT_ID, request.getDesiredDate());

        final StringBuilder employeesList = new StringBuilder();
        final Brigade brigade = (request.getBrigade() != null) ? request.getBrigade() : new Brigade();
        final Label brigadeText = new Label(BRIGADE_TEXT_ID, String.format("%s", brigade.getId()));

        final AjaxLink<Void> goBackButton = new AjaxLink<Void>(GO_BACK_BUTTON_ID) {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.appendJavaScript("window.history.back()");
            }
        };

        add(idText);
        add(workScopeText);
        add(workTypeText);
        add(desiredDateText);
        add(brigadeText);
        add(goBackButton);
    }
}
