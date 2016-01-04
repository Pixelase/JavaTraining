package com.github.pixelase.webproject.webapp.panel.edit;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.EmployeeService;
import com.github.pixelase.webproject.services.WorkTypeService;
import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.edit.register.RegisterCompletePage;
import com.github.pixelase.webproject.webapp.page.profile.ProfilePage;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;
import com.googlecode.wicket.kendo.ui.form.dropdown.DropDownList;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.RangeValidator;

import java.util.List;

public class EmployeeEditPanel extends EditPanel<Employee> {

    public static final String WORK_TYPE_SELECT_ID = "workType";
    public static final String SALARY_TEXT_FIELD_ID = "salary";
    public static final String SUBMIT_BUTTON_ID = "submitButton";

    @SpringBean
    private EmployeeService employeeService;

    @SpringBean
    private WorkTypeService workTypeService;

    public EmployeeEditPanel(String id) {
        super(id, new Employee());
    }

    public EmployeeEditPanel(String id, Employee employee) {
        super(id, employee);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        if (form.getModelObject().getWorkType() == null) {
            form.getModelObject().setWorkType(new WorkType());
        }

        final List<WorkType> workTypes = workTypeService.findAll();
        final DropDownList<WorkType> dropDownList = new DropDownList<>(WORK_TYPE_SELECT_ID, workTypes, new ChoiceRenderer<WorkType>() {
            @Override
            public Object getDisplayValue(WorkType object) {
                return object.getName();
            }
        });
        dropDownList.setOutputMarkupId(true);
        dropDownList.setRequired(true);
        form.add(dropDownList);

        final NumberTextField<Long> salaryTextField = new NumberTextField<>(SALARY_TEXT_FIELD_ID);
        salaryTextField.setOutputMarkupId(true);
        salaryTextField.add(RangeValidator.minimum(0l));
        form.add(salaryTextField);

        form.add(new Button(SUBMIT_BUTTON_ID) {
            @Override
            public void onSubmit() {
                super.onSubmit();

                final Account account = BasicAuthenticationSession.get().getMetaData(BasicAuthenticationSession.REGISTERED_ACCOUNT_KEY);
                final Employee employee = form.getModelObject();

                employee.setAccount(account);

                employeeService.save(employee);

                if (getPage().isBookmarkable()) {
                    setResponsePage(RegisterCompletePage.class);
                } else {
                    //TODO setResponsePage in other situations
                    setResponsePage(ProfilePage.class);
                }
            }
        });
    }
}
