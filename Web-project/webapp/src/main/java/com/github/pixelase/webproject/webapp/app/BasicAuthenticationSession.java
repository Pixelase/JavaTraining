package com.github.pixelase.webproject.webapp.app;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Role;
import com.github.pixelase.webproject.services.AccountService;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Locale;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public class BasicAuthenticationSession extends AuthenticatedWebSession {

    public static final MetaDataKey<Integer> ACCOUNT_ID_KEY = new MetaDataKey<Integer>() {
    };

    @SpringBean
    private AccountService accountService;

    public BasicAuthenticationSession(Request request) {
        super(request);
        Injector.get().inject(this);
        setLocale(Locale.ENGLISH);
    }

    @Override
    protected boolean authenticate(final String login, final String password) {
        if (accountService == null) {
            throw new IllegalArgumentException("service is null");
        }

        final Account account = accountService.findOneByLogin(login);

        return account != null && BCrypt.checkpw(password, account.getCryptedPassword());
    }

    @Override
    public Roles getRoles() {

        final Roles roles = new Roles();
        final Integer id = getMetaData(ACCOUNT_ID_KEY);

        if (id != null) {
            final Account account = accountService.findOne(id);

            if (account != null) {
                for (Role role : account.getRoles()) {
                    roles.add(role.getName());
                }
            }
        }

        return roles;
    }

    @Override
    public void signOut() {
        super.signOut();
        setMetaData(ACCOUNT_ID_KEY, null);
    }

}
