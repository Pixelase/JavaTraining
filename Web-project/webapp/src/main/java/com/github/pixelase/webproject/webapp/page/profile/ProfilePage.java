package com.github.pixelase.webproject.webapp.page.profile;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.services.AccountService;
import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.page.edit.register.AccountRegisterPage;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Alexander Babai on 21.12.2015.
 */

@AuthorizeInstantiation(value = {"tenant", "employee"})
public class ProfilePage extends BasePage {

    @SpringBean
    private AccountService accountService;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new BookmarkablePageLink<Void>("bookmark-link", AccountRegisterPage.class));
        add(new Link<Void>("link") {
            @Override
            public void onClick() {
                final Integer id = BasicAuthenticationSession.get().getMetaData(BasicAuthenticationSession.ACCOUNT_ID_KEY);
                final Account account = accountService.findOne(id);

                setResponsePage(new AccountRegisterPage(account));
            }
        });

    }
}
