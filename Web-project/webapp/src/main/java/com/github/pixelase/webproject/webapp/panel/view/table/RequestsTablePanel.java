package com.github.pixelase.webproject.webapp.panel.view.table;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.AccountService;
import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.Iterator;

/**
 * Created by Alexander Babai on 07.01.2016.
 */
public class RequestsTablePanel extends Panel {

    public static final String ID_LABEL_ID = "id-label";
    public static final String WORK_TYPE_LABEL_ID = "work-type-label";
    public static final String WORK_SCOPE_LAVE_ID = "work-scope-lave";
    public static final String DESIRED_DATE_LABEL_ID = "desired-date-label";
    public static final String BRIGADE_ID_LABEL_ID = "brigade-Id-label";
    public static final String OPEN_BUTTON_ID = "open-button";
    @SpringBean
    private AccountService accountService;

    public RequestsTablePanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        final WorkRequestDataProvider requestDataProvider = new WorkRequestDataProvider();
        final DataView<WorkRequest> dataView = new DataView<WorkRequest>("requests-list", requestDataProvider, 3) {
            @Override
            protected void populateItem(Item<WorkRequest> item) {
                final WorkRequest request = item.getModelObject();

                item.add(new Label(ID_LABEL_ID, request.getId()));
                item.add(new Label(WORK_TYPE_LABEL_ID, request.getWorkType().getName()));
                item.add(new Label(WORK_SCOPE_LAVE_ID, request.getWorkScope().getName()));
                item.add(new Label(DESIRED_DATE_LABEL_ID, request.getDesiredDate()));
                item.add(new Label(BRIGADE_ID_LABEL_ID, request.getBrigade()));
                item.add(new Link(OPEN_BUTTON_ID) {
                    @Override
                    public void onClick() {
                        //TODO open detail info about request
                    }
                });

            }
        };

        add(dataView);
        add(new PagingNavigator("paging", dataView));
    }

    private class WorkRequestDataProvider extends SortableDataProvider<WorkRequest, Object> {

        private final Tenant tenant;

        public WorkRequestDataProvider() {
            super();

            final Integer accountId = BasicAuthenticationSession.get().getMetaData(BasicAuthenticationSession.ACCOUNT_ID_KEY);
            final Account account = accountService.findOne(accountId);
            tenant = account.getTenant();

            setSort("id", SortOrder.ASCENDING);
        }

        @Override
        public Iterator<? extends WorkRequest> iterator(long first, long count) {

            SortParam<Object> sort = getSort();
            ISortState<Object> sortState = getSortState();
            SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());

            //TODO sorting and paging via request service
            //Find all request by tenant + Pageable and Sort methods
            return tenant.getWorkRequests().iterator();
        }

        @Override
        public long size() {
            return tenant.getWorkRequests().size();
        }

        @Override
        public IModel<WorkRequest> model(WorkRequest object) {
            return new CompoundPropertyModel<>(object);
        }

    }
}
