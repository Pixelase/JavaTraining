package com.github.pixelase.webproject.webapp.panel.view.table;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.AccountService;
import com.github.pixelase.webproject.services.WorkRequestService;
import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.view.one.WorkRequestViewPage;
import com.github.pixelase.webproject.webapp.panel.view.table.common.TablePanel;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
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

    @SpringBean
    private AccountService accountService;

    @SpringBean
    private WorkRequestService requestService;

    public RequestsTablePanel(String id) {
        super(id);
    }

    @Override
    protected DataView<?> createDataView(String id, int itemsPerPage) {
        return new DataView<WorkRequest>(id, new WorkRequestDataProvider(), itemsPerPage) {
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
                        setResponsePage(new WorkRequestViewPage(request));
                    }
                });
            }
        };

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
            final SortParam<Object> sort = getSort();
            final ISortState<Object> sortState = getSortState();
            final SortOrder wicketSort = sortState.getPropertySortOrder(sort.getProperty());
            Sort springSort = null;

            switch (wicketSort) {
                case ASCENDING:
                    springSort = new Sort(Sort.Direction.ASC, sort.getProperty().toString());
                    break;
                case DESCENDING:
                    springSort = new Sort(Sort.Direction.DESC, sort.getProperty().toString());
                    break;
            }

            final int pageNumber = (int) first / (int) count;
            final PageRequest pageRequest = new PageRequest(pageNumber, (int) count, springSort);
            final Page<WorkRequest> page = requestService.findAll(tenant, pageRequest);

            return page.iterator();
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
