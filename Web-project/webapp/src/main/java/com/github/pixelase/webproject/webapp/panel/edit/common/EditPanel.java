package com.github.pixelase.webproject.webapp.panel.edit.common;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

public abstract class EditPanel<T> extends Panel {

    protected Form<T> form;

    public EditPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        form = new Form<>("form", new CompoundPropertyModel<>(getModelObject()));
        add(form);
    }

    protected abstract T getModelObject();
}
