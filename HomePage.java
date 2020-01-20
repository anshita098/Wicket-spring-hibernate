package com.github.anirudhvarma12.whs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Popup;

import org.apache.log4j.Logger;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.PopupSettings;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.lang.Generics;
import org.apache.wicket.util.string.StringValue;

public class HomePage extends WebPage {

    
    @SpringBean
    private UserService service;

    private static final long serialVersionUID = 1L;

    private static Logger LOG = Logger.getLogger(HomePage.class);


    public HomePage(PageParameters parameters) {
       
    	super(parameters);
    	
    	List<Bank> users = new ArrayList<>();
        if (parameters.isEmpty()) {
            users.addAll(service.getUsers());
        } else {
            List<StringValue> nameSearch = parameters.getValues("nameSearch");
            StringValue nameValue = nameSearch.get(0);
            String name = nameValue.toString();
            users.addAll(service.getUsersByName(name));
        }
        add(new UsersList("users", users));
        add(new SearchForm("searchForm"));
        add(new HomeLink("homeLink"));
      

    }
    
}
