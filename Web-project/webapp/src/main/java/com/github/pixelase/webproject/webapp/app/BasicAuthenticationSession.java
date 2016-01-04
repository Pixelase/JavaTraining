package com.github.pixelase.webproject.webapp.app;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.services.AccountService;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public class BasicAuthenticationSession extends AuthenticatedWebSession {

    public static final MetaDataKey<Account> LOGGED_ACCOUNT_KEY = new MetaDataKey<Account>() {
    };

    public static final MetaDataKey<Account> REGISTERED_ACCOUNT_KEY = new MetaDataKey<Account>() {
    };

    @SpringBean
    private AccountService accountService;

    public BasicAuthenticationSession(Request request) {
        super(request);
        Injector.get().inject(this);
    }

    @Override
    protected boolean authenticate(String login, String password) {
        if (accountService == null) {
            throw new IllegalArgumentException("service is null");
        }

        final String cryptedPassword = accountService.findOneByLogin(login).getCryptedPassword();
        final boolean result = BCrypt.checkpw(password, cryptedPassword);

        return result;
    }

    @Override
    public Roles getRoles() {
        return new Roles(getMetaData(LOGGED_ACCOUNT_KEY).getRoles().toArray(new String[0]));
    }

}
