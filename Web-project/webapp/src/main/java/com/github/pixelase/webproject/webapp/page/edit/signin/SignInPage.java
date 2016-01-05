package com.github.pixelase.webproject.webapp.page.edit.signin;

import com.github.pixelase.webproject.webapp.page.edit.common.EditPage;
import com.github.pixelase.webproject.webapp.panel.edit.SignInEditPanel;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public class SignInPage extends EditPage {
    public SignInPage() {
        super(new SignInEditPanel(EDIT_PANEL_ID));
        denyAccessForSignedUser();
    }
}
