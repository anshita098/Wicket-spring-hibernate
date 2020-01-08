package com.github.anirudhvarma12.whs;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage {

    @SpringBean
    public SpringInterface inteface;

    private static final long serialVersionUID = 1L;

    private static Logger LOG = Logger.getLogger(HomePage.class);

    public HomePage() {
       
        LOG.debug("Implmentation says " + inteface.getlist());
           
       add(new ListView<Bank>("listView", inteface.getlist())
       {
              public void populateItem(final ListItem<Bank> item)
              {
                      final Bank c = item.getModelObject();
                      item.add(new Label("id", c.getId()));
                      item.add(new Label("email",c.getEmail()));
               	   	  item.add(new Label("firstname",c.getFirstname()));
               	   	  item.add(EditBook.link("edit", c.getId()));
              }
       });
    }

}
