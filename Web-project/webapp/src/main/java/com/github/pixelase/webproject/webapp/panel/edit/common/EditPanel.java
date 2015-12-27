package com.github.pixelase.webproject.webapp.panel.edit.common;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

public abstract class EditPanel<T> extends Panel {

    protected final Form<T> form;

    public EditPanel(String id, T formModelObject) {
        super(id);
        form = new Form<>("form", new CompoundPropertyModel<>(formModelObject));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(form);
    }
}