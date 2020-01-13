package com.github.anirudhvarma12.whs;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.StringValue;

public class HomePage extends WebPage {

    
    @SpringBean
    private UserService service;

    private static final long serialVersionUID = 1L;

    private static Logger LOG = Logger.getLogger(HomePage.class);

    public HomePage(PageParameters parameters) {
       
    	super(parameters);
   
        List<Bank> users = new ArrayList<>();
            users.addAll(service.getUsers());
           add(new UsersList("users", users));
        
        
    }
}