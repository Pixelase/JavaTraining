package com.github.pixelase.webproject.webapp.page.view.one;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.panel.view.card.BrigadeCardPanel;

/**
 * Created by Alexander Babai on 10.01.2016.
 */
public class BrigadeViewPage extends BasePage {
    public static final String BRIGADE_CARD_PANEL_ID = "brigade-card-panel";

    public BrigadeViewPage(final Brigade brigade) {
        add(new BrigadeCardPanel(BRIGADE_CARD_PANEL_ID, brigade));
    }
}
