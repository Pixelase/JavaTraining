package com.github.pixelase.webproject.webapp.page.edit.request;

import com.github.pixelase.webproject.webapp.page.base.BasePage;
import com.github.pixelase.webproject.webapp.utils.RoleUtils;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

/**
 * Created by Alexander Babai on 28.12.2015.
 */

@AuthorizeInstantiation(value = RoleUtils.TENANT_ROLE)
public class RequestCreatedPage extends BasePage {
}
