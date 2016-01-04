package com.github.pixelase.webproject.webapp.page.edit.register;

import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.webapp.page.edit.common.EditPage;
import com.github.pixelase.webproject.webapp.panel.edit.EmployeeEditPanel;

/**
 * Created by Alexander Babai on 27.12.2015.
 */
public class EmployeeRegisterPage extends EditPage {

    public EmployeeRegisterPage() {
        super(new EmployeeEditPanel(EDIT_PANEL_ID));
    }

    public EmployeeRegisterPage(Employee employee) {
        super(new EmployeeEditPanel(EDIT_PANEL_ID, employee));
    }
}
