package com.github.anirudhvarma12.whs;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class EditLink extends Link<Void> {
    private ListItem<Bank> item;

    public EditLink(String id, ListItem<Bank> item) {
        super(id);
        this.item = item;
    }

    @Override
    public void onClick() {
        int userId = item.getModelObject().getId();
        PageParameters parameters = new PageParameters();
        parameters.add("id", userId);
        setResponsePage(EditPage.class, parameters);
    }
}