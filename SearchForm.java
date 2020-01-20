package com.github.anirudhvarma12.whs;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SearchForm extends Form<SearchForm> {
    private String nameSearch;

    public SearchForm(String id) {
        super(id);
        setModel(new CompoundPropertyModel<>(this));
        add(new RequiredTextField<String>("nameSearch"));
    }

    @Override
    protected void onSubmit() {
        PageParameters parameters = new PageParameters();
        parameters.add("nameSearch", nameSearch);
        setResponsePage(HomePage.class, parameters);
    }
}