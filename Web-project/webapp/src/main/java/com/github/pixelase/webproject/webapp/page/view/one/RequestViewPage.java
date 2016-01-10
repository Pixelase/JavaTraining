package com.github.pixelase.webproject.webapp.page.view.one;

import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.panel.view.card.RequestCardPanel;

/**
 * Created by Alexander Babai on 09.01.2016.
 */
public class RequestViewPage extends BasePage {

    public static final String REQUEST_CARD_PANEL_ID = "request-card-panel";

    public RequestViewPage(WorkRequest workRequest) {
        add(new RequestCardPanel(REQUEST_CARD_PANEL_ID, workRequest));
    }
}
