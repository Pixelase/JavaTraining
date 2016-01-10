package com.github.pixelase.webproject.webapp.panel.view.card;

import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.webapp.page.edit.register.EmployeeRegisterPage;
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
        roles = RoleUtils.EMPLOYEE_ROLE)
public class EmployeeCardPanel extends Panel {

    public static final String WORK_TYPE_TEXT_ID = "work-type-text";
    public static final String SALARY_TEXT_ID = "salary-text";
    public static final String EDIT_INFO_BUTTON_ID = "edit-info-button";

    public EmployeeCardPanel(final String id, final Employee employee) {
        super(id);

        final WorkType workType = (employee.getWorkType() != null) ?
                employee.getWorkType() : new WorkType();
        add(new Label(WORK_TYPE_TEXT_ID, workType.getName()));
        add(new Label(SALARY_TEXT_ID, employee.getSalary()));
        add(new Link<Void>(EDIT_INFO_BUTTON_ID) {
            @Override
            public void onClick() {
                setResponsePage(new EmployeeRegisterPage(employee));
            }
        });

    }
}
