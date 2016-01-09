package com.github.pixelase.webproject.webapp.panel.view.table.common;

import com.github.pixelase.webproject.webapp.panel.view.table.common.navigator.CustomAjaxPagingNavigator;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;

/**
 * Created by Alexander Babai on 07.01.2016.
 */
public abstract class TablePanel extends Panel {

    public static final String DATA_CONTAINER_ID = "data-container";
    public static final String TH_LIST_ITEMS_ID = "th-list-items";
    public static final String DATA_VIEW_ID = "data-view";
    public static final String PAGING_NAVIGATOR_ID = "paging-navigator";

    protected final WebMarkupContainer dataContainer;
    protected final RepeatingView thListItems;
    protected final AjaxPagingNavigator pagingNavigator;
    protected final DataView<?> dataView;

    public TablePanel(String id) {
        super(id);

        dataContainer = new WebMarkupContainer(DATA_CONTAINER_ID);
        dataContainer.setOutputMarkupId(true);

        thListItems = new RepeatingView(TH_LIST_ITEMS_ID);
        thListItems.add(new Label(thListItems.newChildId(), "ID"));
        thListItems.add(new Label(thListItems.newChildId(), "Work type"));
        thListItems.add(new Label(thListItems.newChildId(), "Work scope"));
        thListItems.add(new Label(thListItems.newChildId(), "Desired date"));
        thListItems.add(new Label(thListItems.newChildId(), "Brigade ID"));
        thListItems.add(new Label(thListItems.newChildId(), "Actions"));

        final int itemsPerPage = 5;
        dataView = createDataView(DATA_VIEW_ID, itemsPerPage);
        pagingNavigator = new CustomAjaxPagingNavigator(PAGING_NAVIGATOR_ID, dataView) {
            @Override
            protected void onAjaxEvent(AjaxRequestTarget target) {
                target.add(dataContainer);
                target.appendJavaScript(
                        " var tmp = document.createElement(\"input\");\n" +
                                " document.body.appendChild(tmp);\n" +
                                " tmp.focus();\n" +
                                " document.body.removeChild(tmp);\n"
                );
            }
        };

        add(dataContainer);
        dataContainer.add(dataView);
        dataContainer.add(pagingNavigator);
        dataContainer.add(thListItems);
    }

    protected abstract DataView<?> createDataView(String id, int itemsPerPage);
}
