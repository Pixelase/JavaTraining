package com.github.pixelase.webproject.webapp.panel.edit;

import com.github.pixelase.webproject.dataaccess.model.*;
import com.github.pixelase.webproject.services.*;
import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.edit.request.RequestCreatedPage;
import com.github.pixelase.webproject.webapp.page.view.many.RequestsPage;
import com.github.pixelase.webproject.webapp.panel.edit.common.EditPanel;
import com.googlecode.wicket.kendo.ui.form.datetime.DatePicker;
import com.googlecode.wicket.kendo.ui.form.dropdown.DropDownList;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * Created by Alexander Babai on 10.01.2016.
 */
public class RequestEditPanel extends EditPanel<WorkRequest> {

    public static final String WORK_TYPE_SELECT_ID = "workType";
    public static final String SUBMIT_BUTTON_ID = "submitButton";
    public static final String RESET_BUTTON_ID = "resetButton";
    public static final String REQUEST_EDIT_PANEL_CSS_CLASS = "request-edit-panel";
    public static final String WORK_SCOPE_SELECT_ID = "workScope";
    public static final String DATE_PICKER_ID = "desiredDate";


    @SpringBean
    private AccountService accountService;

    @SpringBean
    private ManagerService managerService;

    @SpringBean
    private WorkRequestService requestService;

    @SpringBean
    private WorkScopeService workScopeService;

    @SpringBean
    private WorkTypeService workTypeService;

    public RequestEditPanel(final String id) {
        super(id, new WorkRequest());
    }

    public RequestEditPanel(final String id, final WorkRequest formModelObject) {
        super(id, formModelObject);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        appendCssClass(REQUEST_EDIT_PANEL_CSS_CLASS);

        if (form.getModelObject().getWorkScope() == null) {
            form.getModelObject().setWorkScope(new WorkScope());
        }

        final List<WorkScope> workScopes = workScopeService.findAll();
        final DropDownList<WorkScope> workScopeDropDownList = new DropDownList<>(WORK_SCOPE_SELECT_ID, workScopes, new ChoiceRenderer<WorkScope>() {
            @Override
            public Object getDisplayValue(WorkScope object) {
                return object.getName();
            }
        });
        workScopeDropDownList.setOutputMarkupId(true);
        workScopeDropDownList.setRequired(true);
        form.add(workScopeDropDownList);

        if (form.getModelObject().getWorkType() == null) {
            form.getModelObject().setWorkType(new WorkType());
        }

        final List<WorkType> workTypes = workTypeService.findAll();
        final DropDownList<WorkType> workTypeDropDownList = new DropDownList<>(WORK_TYPE_SELECT_ID, workTypes, new ChoiceRenderer<WorkType>() {
            @Override
            public Object getDisplayValue(WorkType object) {
                return object.getName();
            }
        });
        workTypeDropDownList.setOutputMarkupId(true);
        workTypeDropDownList.setRequired(true);
        form.add(workTypeDropDownList);

        final String pattern = "dd.MM.yy";
        final DatePicker datePicker = new DatePicker(DATE_PICKER_ID, pattern);
        datePicker.setOutputMarkupId(true);
        form.add(datePicker);

        form.add(new Button(SUBMIT_BUTTON_ID) {
            @Override
            public void onSubmit() {
                super.onSubmit();

                WorkRequest request = form.getModelObject();

                if (getPage().wasCreatedBookmarkable()) {
                    final AuthenticatedWebSession session = BasicAuthenticationSession.get();
                    final Integer accountId = session.getMetaData(BasicAuthenticationSession.ACCOUNT_ID_KEY);
                    final Account account = accountService.findOne(accountId);
                    final Tenant tenant = account.getTenant();

                    request.setTenant(tenant);
                    request = requestService.save(request);

                    managerService.registerBrigade(request);

                    setResponsePage(RequestCreatedPage.class);

                } else {
                    requestService.save(request);
                    setResponsePage(RequestsPage.class);
                }
            }
        });

        form.add(new ResetFormLink(RESET_BUTTON_ID));
    }
}
