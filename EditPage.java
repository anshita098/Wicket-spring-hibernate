package com.github.anirudhvarma12.whs;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

public class EditPage extends WebPage {
    private int userId;

    public EditPage(PageParameters parameters) {
        super(parameters);
        List<StringValue> idParameters = parameters.getValues("id");
        StringValue idValue = idParameters.get(0);
        userId = idValue.toInt();
        add(new EditForm("editForm", userId));
    }
}