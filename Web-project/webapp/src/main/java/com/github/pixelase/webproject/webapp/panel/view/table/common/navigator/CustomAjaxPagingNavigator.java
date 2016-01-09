package com.github.pixelase.webproject.webapp.panel.view.table.common.navigator;

import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.navigation.paging.IPageable;

/**
 * Created by Alexander Babai on 09.01.2016.
 */
public class CustomAjaxPagingNavigator extends AjaxPagingNavigator {

    public CustomAjaxPagingNavigator(String id, IPageable pageable) {
        super(id, pageable);
    }
}
