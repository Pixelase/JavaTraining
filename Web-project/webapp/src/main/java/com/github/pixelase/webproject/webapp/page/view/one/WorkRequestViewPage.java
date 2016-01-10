package com.github.pixelase.webproject.webapp.page.view.one;

import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.panel.view.card.WorkRequestCardWide;
import com.github.pixelase.webproject.webapp.utils.RoleUtils;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

/**
 * Created by Alexander Babai on 09.01.2016.
 */
@AuthorizeInstantiation(value = RoleUtils.TENANT_ROLE)
public class WorkRequestViewPage extends BasePage {

    public static final String REQUEST_CARD_WIDE_ID = "request-card-wide";

    public WorkRequestViewPage(WorkRequest workRequest) {
        add(new WorkRequestCardWide(REQUEST_CARD_WIDE_ID, workRequest));
    }
}
