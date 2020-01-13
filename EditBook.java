package com.github.anirudhvarma12.whs;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.FormComponentFeedbackBorder;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

public final class EditBook extends WebPage
{
        public EditBook(final Bank book)
    {
        // Create and add feedback panel to page
        add(new FeedbackPanel("feedback"));

        // Add edit book form to page
        add(new EditBookForm("editBookForm", book));
    }

    /**
     * Gets a link to a page that will edit a book
     * 
     * @param name
     *            The name of the link
     * @param id
     *            The id of the book that the page will edit
     * @return The page link
     */
    public static Link<Void> link(final String name, final long id)
    {
        return new Link<Void>(name)
        {
            /**
             * @see org.apache.wicket.markup.html.link.Link#onClick()
             */
            @Override
            public void onClick()
            {
                setResponsePage(new EditBook(Bank.get(id)));
            }
        };
    }

    /**
     * Form that edits a book
     * 
     * @author Jonathan Locke
     */
    static public final class EditBookForm extends Form<Bank>
    {
        /**
         * Constructor
         * 
         * @param id
         *            id of form
         * @param book
         *            Book model
         */
        public EditBookForm(final String id, final Bank book)
        {
            super(id);
            CompoundPropertyModel model = new CompoundPropertyModel(book);
            this.setModel(model);
            this.add(new TextField("firstname"));           
        }  
        /**
         * Show the resulting valid edit
         */
        @Override
        public final void onSubmit()
        {
            final Bank book = getModelObject();


            setResponsePage(HomePage.class);

            // setRedirect(true);
        }
    }
}