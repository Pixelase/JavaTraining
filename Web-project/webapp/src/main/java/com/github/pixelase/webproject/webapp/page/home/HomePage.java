package com.github.pixelase.webproject.webapp.page.home;

import com.github.pixelase.webproject.services.TenantService;
import com.github.pixelase.webproject.webapp.page.base.BasePage;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends BasePage {

    @SpringBean
    TenantService service;

    public HomePage() {
        super();
    }
}
