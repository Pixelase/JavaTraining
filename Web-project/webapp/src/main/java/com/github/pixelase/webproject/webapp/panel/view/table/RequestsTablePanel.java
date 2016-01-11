package com.github.pixelase.webproject.webapp.panel.view.table;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.AccountService;
import com.github.pixelase.webproject.services.WorkRequestService;
import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.view.one.RequestViewPage;
import com.github.pixelase.webproject.webapp.panel.view.table.common.TablePanel;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Iterator;

/**
 * Created by Alexander Babai on 07.01.2016.
 */
public class RequestsTablePanel extends TablePanel {

    public static final String ID_LABEL_ID = "id-label";
    public static final String WORK_TYPE_LABEL_ID = "work-type-label";
    public static final String WORK_SCOPE_LAVE_ID = "work-scope-lave";
    public static final String DESIRED_DATE_LABEL_ID = "desired-date-label";
    public static final String BRIGADE_ID_LABEL_ID = "brigade-Id-label";
    public static final String OPEN_BUTTON_ID = "open-button";

    public RequestsTablePanel(final String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        thListItems.add(new Label(thListItems.newChildId(), getString("requests_table_panel_id_col")));
        thListItems.add(new Label(thListItems.newChildId(), getString("requests_table_panel_work_type_col")));
        thListItems.add(new Label(thListItems.newChildId(), getString("requests_table_panel_work_scope_col")));
        thListItems.add(new Label(thListItems.newChildId(), getString("requests_table_panel_desired_date_col")));
        thListItems.add(new Label(thListItems.newChildId(), getString("requests_table_panel_brigade_row")));
        thListItems.add(new Label(thListItems.newChildId(), getString("requests_table_panel_actions_col")));
    }

    @Override
    protected DataView<?> createDataView(final String id, final int itemsPerPage) {
        return new DataView<WorkRequest>(id, new WorkRequestDataProvider(itemsPerPage), itemsPerPage) {
            @Override
            protected void populateItem(final Item<WorkRequest> item) {
                final WorkRequest request = item.getModelObject();

                item.add(new Label(ID_LABEL_ID, request.getId()));
                item.add(new Label(WORK_TYPE_LABEL_ID, request.getWorkType().getName()));
                item.add(new Label(WORK_SCOPE_LAVE_ID, request.getWorkScope().getName()));
                item.add(new Label(DESIRED_DATE_LABEL_ID, request.getDesiredDate()));
                item.add(new Label(BRIGADE_ID_LABEL_ID, (request.getBrigade() != null) ? request.getBrigade().getId() : null));
                item.add(new Link(OPEN_BUTTON_ID) {
                    @Override
                    public void onClick() {
                        setResponsePage(new RequestViewPage(request));
                    }
                });
            }
        };

    }

    private class WorkRequestDataProvider extends SortableDataProvider<WorkRequest, Object> {

        private final Tenant tenant;
        private final int itemsPerPage;
        @SpringBean
        private AccountService accountService;
        @SpringBean
        private WorkRequestService requestService;

        public WorkRequestDataProvider(final int itemsPerPage) {
            super();

            Injector.get().inject(this);

            final Integer accountId = BasicAuthenticationSession.get().getMetaData(BasicAuthenticationSession.ACCOUNT_ID_KEY);
            final Account account = accountService.findOne(accountId);
            tenant = account.getTenant();
            this.itemsPerPage = itemsPerPage;


            setSort("id", SortOrder.ASCENDING);
        }

        @Override
        public Iterator<? extends WorkRequest> iterator(long first, long count) {
            final SortParam<Object> sort = getSort();
            final ISortState<Object> sortState = getSortState();
            final SortOrder sortOrder = sortState.getPropertySortOrder(sort.getProperty());
            final Sort springSort = convertWicketSortToSpringSort(sort, sortOrder);

            final int pageNumber = (int) first / (int) count;
            final PageRequest pageRequest = new PageRequest(pageNumber, itemsPerPage, springSort);
            final Page<WorkRequest> page = requestService.findAll(tenant, pageRequest);

            return page.iterator();
        }

        @Override
        public long size() {
            return requestService.findAll(tenant).size();
        }

        @Override
        public IModel<WorkRequest> model(WorkRequest object) {
            return new CompoundPropertyModel<>(object);
        }

    }
}
