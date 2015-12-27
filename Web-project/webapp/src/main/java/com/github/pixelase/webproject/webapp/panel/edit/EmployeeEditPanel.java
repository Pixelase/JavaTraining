package com.github.pixelase.webproject.webapp.panel.edit;

import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;

public class EmployeeEditPanel extends EditPanel<Employee> {

    public EmployeeEditPanel(String id) {
        super(id, new Employee());
    }

    public EmployeeEditPanel(String id, Employee employee) {
        super(id, employee);
    }

}
