package com.github.pixelase.webproject.webapp.panel.view.table.common;

import com.github.pixelase.webproject.webapp.panel.view.table.common.navigator.CustomAjaxPagingNavigator;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.springframework.data.domain.Sort;

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

    protected Sort convertWicketSortToSpringSort(SortParam<?> sort, SortOrder sortOrder) {
        Sort springSort = null;

        switch (sortOrder) {
            case ASCENDING:
                springSort = new Sort(Sort.Direction.ASC, sort.getProperty().toString());
                break;
            case DESCENDING:
                springSort = new Sort(Sort.Direction.DESC, sort.getProperty().toString());
                break;
        }

        return springSort;
    }
}
