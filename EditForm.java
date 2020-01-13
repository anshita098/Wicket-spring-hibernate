package com.github.anirudhvarma12.whs;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class EditForm extends Form<EditForm> {
    private FormComponent email;
    private FormComponent firstname;
    private FormComponent password;
    private FormComponent age;
    private int userId;
    	
    @SpringBean
    private UserService service;

    public EditForm(String id, int userId) {
        super(id);
        this.userId = userId;
        Bank oldUser = service.getUserById(userId);
        email = new TextField<>(
                "email",
                new PropertyModel<>(oldUser, "email")
        );
        firstname = new TextField<>(
                "firstname",
                new PropertyModel<>(oldUser, "firstname")
        );
        password = new TextField<>(
                "password",
                new PropertyModel<>(oldUser, "password")
        );
        age = new TextField<>(
                "age",
                new PropertyModel<>(oldUser, "age")
        );
        add(email);
        add(firstname);
        add(password);
        add(age);
        }

    @Override
    protected void onSubmit() {
        Bank user = new Bank(
                email.getInput(),
                firstname.getInput(),
                password.getInput(),
               age.getInput()
        );
        service.updateUser(userId, user);
        setResponsePage(HomePage.class);
    }
}