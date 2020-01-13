package com.github.anirudhvarma12.whs;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class UsersList extends ListView<Bank> {
    public UsersList(String id, List<Bank> users) {
        super(id, users);
    }


	@Override
    public void populateItem(ListItem<Bank> item) {
        final Bank user = item.getModelObject();
        item.add(nameLabel(user));
         item.add(new EditLink("editLink", item));
    }

	private Label nameLabel(Bank user) {
        return new Label(
                "name",
                user.getEmail() + " " + user.getFirstname()+ " " + user.getPassword()+ " " + user.getAge()
        );
    }

	
}