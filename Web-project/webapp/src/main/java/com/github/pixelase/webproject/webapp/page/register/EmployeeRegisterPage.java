package com.github.pixelase.webproject.webapp.page.register;

import com.github.pixelase.webproject.webapp.page.register.common.RegisterPage;
import com.github.pixelase.webproject.webapp.panel.edit.EmployeeEditPanel;

/**
 * Created by Alexander Babai on 27.12.2015.
 */
public class EmployeeRegisterPage extends RegisterPage {

    public EmployeeRegisterPage() {
        super(new EmployeeEditPanel(EDIT_PANEL_ID));
    }
}
