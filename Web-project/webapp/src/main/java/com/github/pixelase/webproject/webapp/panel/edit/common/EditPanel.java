package com.github.pixelase.webproject.webapp.panel.edit.common;

import org.apache.wicket.ClassAttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

public abstract class EditPanel<T> extends Panel {

    public static final String FORM_ID = "form";
    public static final String PANEL_HOLDER_ID = "panel-holder";
    protected final Form<T> form;
    protected final WebMarkupContainer panelHolder;

    public EditPanel(String id) {
        super(id);
        form = new Form<>(FORM_ID);
        panelHolder = new WebMarkupContainer(PANEL_HOLDER_ID);
    }

    public EditPanel(String id, T formModelObject) {
        super(id);
        form = new Form<>(FORM_ID, new CompoundPropertyModel<>(formModelObject));
        panelHolder = new WebMarkupContainer(PANEL_HOLDER_ID);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        panelHolder.add(form);
        add(panelHolder);
    }

    public void appendCssClass(String className) {
        panelHolder.add(ClassAttributeModifier.append("class", className));
    }

    protected class ResetFormLink extends Link<Void> {

        public ResetFormLink(String id) {
            super(id);
        }

        @Override
        public void onClick() {
            form.clearInput();
        }
    }
}
