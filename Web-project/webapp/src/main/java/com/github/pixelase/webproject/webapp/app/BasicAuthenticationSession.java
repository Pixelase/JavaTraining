package com.github.pixelase.webproject.webapp.app;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

/**
 * Created by Alexander Babai on 21.12.2015.
 */
public class BasicAuthenticationSession extends AuthenticatedWebSession {

    private final Account account = new Account();

    public BasicAuthenticationSession(Request request) {
        super(request);
    }

    @Override
    protected boolean authenticate(String username, String password) {
        return username.equals(password) && password.equals(password);
    }

    @Override
    public Roles getRoles() {
        Roles resultRoles = new Roles();

        if (isSignedIn())
            resultRoles.add("SIGNED_IN");

        if (account.getUserName().equals("admin"))
            resultRoles.add(Roles.ADMIN);

        return resultRoles;
    }

    private class Account {
        private final String userName = "admin";
        private final String password = "test";

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        public Account() {
        }
    }
}
