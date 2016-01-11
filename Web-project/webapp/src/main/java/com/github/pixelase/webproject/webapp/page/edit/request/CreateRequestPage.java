package com.github.pixelase.webproject.webapp.page.edit.request;

import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.webapp.page.edit.common.EditPage;
import com.github.pixelase.webproject.webapp.panel.edit.RequestEditPanel;

/**
 * Created by Alexander Babai on 10.01.2016.
 */
public class CreateRequestPage extends EditPage {
    public CreateRequestPage() {
        super(new RequestEditPanel(EDIT_PANEL_ID));
        denyAccessForAnonymousUser();
    }

    public CreateRequestPage(final WorkRequest workRequest) {
        super(new RequestEditPanel(EDIT_PANEL_ID, workRequest));
    }
}
