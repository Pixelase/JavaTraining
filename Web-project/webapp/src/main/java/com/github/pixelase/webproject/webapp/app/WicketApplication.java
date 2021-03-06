package com.github.pixelase.webproject.webapp.app;

import com.github.pixelase.webproject.webapp.page.edit.signin.SignInPage;
import com.github.pixelase.webproject.webapp.page.home.HomePage;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 *
 * @see src/test/java/сom.github.pixelase.webproject.webapp.Start#main(String[] args)
 */
@Component("MyWebApplication")
public class WicketApplication extends AuthenticatedWebApplication {

    @Autowired
    private ApplicationContext context;

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();

        getComponentInstantiationListeners().add(new SpringComponentInjector(this, context));
        getMarkupSettings().setStripWicketTags(true);
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return BasicAuthenticationSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return SignInPage.class;
    }
}
