package com.github.pixelase.webproject.webapp.panel.view.table;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.AccountService;
import com.github.pixelase.webproject.services.BrigadeService;
import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import com.github.pixelase.webproject.webapp.page.view.one.BrigadeViewPage;
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
 * Created by Alexander Babai on 10.01.2016.
 */
public class BrigadesTablePanel extends TablePanel {

    public static final String OPEN_BUTTON_ID = "open-button";
    public static final String REAL_DATE_LABEL_ID = "real-date-label";
    public static final String WORK_REQUEST_LABEL_ID = "work-request-label";
    public static final String ID_LABEL_ID = "id-label";

    public BrigadesTablePanel(String id) {
        super(id);

        thListItems.add(new Label(thListItems.newChildId(), "ID"));
        thListItems.add(new Label(thListItems.newChildId(), "Request ID"));
        thListItems.add(new Label(thListItems.newChildId(), "Real date"));
        thListItems.add(new Label(thListItems.newChildId(), "Actions"));
    }

    @Override
    protected DataView<?> createDataView(String id, int itemsPerPage) {
        return new DataView<Brigade>(id, new BrigadeDataProvider(itemsPerPage), itemsPerPage) {
            @Override
            protected void populateItem(Item<Brigade> item) {
                final Brigade brigade = item.getModelObject();
                final WorkRequest request = (brigade.getWorkRequest() != null) ?
                        brigade.getWorkRequest() : new WorkRequest();

                item.add(new Label(ID_LABEL_ID, brigade.getId()));
                item.add(new Label(WORK_REQUEST_LABEL_ID, request.getId()));
                item.add(new Label(REAL_DATE_LABEL_ID, brigade.getRealDate()));
                item.add(new Link(OPEN_BUTTON_ID) {
                    @Override
                    public void onClick() {
                        setResponsePage(new BrigadeViewPage(brigade));
                    }
                });
            }
        };

    }

    private class BrigadeDataProvider extends SortableDataProvider<Brigade, Object> {

        private final Employee employee;
        private final int itemsPerPage;

        @SpringBean
        private AccountService accountService;

        @SpringBean
        private BrigadeService brigadeService;

        public BrigadeDataProvider(int itemsPerPage) {
            super();

            Injector.get().inject(this);

            final Integer accountId = BasicAuthenticationSession.get().getMetaData(BasicAuthenticationSession.ACCOUNT_ID_KEY);
            final Account account = accountService.findOne(accountId);
            employee = account.getEmployee();
            this.itemsPerPage = itemsPerPage;


            setSort("id", SortOrder.ASCENDING);
        }

        @Override
        public Iterator<? extends Brigade> iterator(long first, long count) {
            final SortParam<Object> sort = getSort();
            final ISortState<Object> sortState = getSortState();
            final SortOrder sortOrder = sortState.getPropertySortOrder(sort.getProperty());
            Sort springSort = convertWicketSortToSpringSort(sort, sortOrder);

            final int pageNumber = (int) first / (int) count;
            final PageRequest pageRequest = new PageRequest(pageNumber, itemsPerPage, springSort);
            final Page<Brigade> page = brigadeService.findAll(employee, pageRequest);

            return page.iterator();
        }

        @Override
        public long size() {
            return employee.getBrigades().size();
        }

        @Override
        public IModel<Brigade> model(Brigade object) {
            return new CompoundPropertyModel<>(object);
        }

    }
}
