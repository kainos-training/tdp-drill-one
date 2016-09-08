package com.kainos.drillzone.views;

import com.codahale.metrics.MetricRegistry;
import com.kainos.drillone.DataStore;
import com.kainos.drillone.DrillOneApplication;
import com.kainos.drillone.config.DrillOneConfiguration;
import com.kainos.drillone.models.Book;
import com.kainos.drillone.resources.BookResource;
import com.kainos.drillone.views.BookUpdateView;
import io.dropwizard.testing.junit.ResourceTestRule;
import io.dropwizard.views.View;
import io.dropwizard.views.ViewMessageBodyWriter;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

/**
 * Created by williamst on 07/09/2016.
 */
public class UpdateBookTest {
    public DataStore dataStore = new DataStore();
   BookResource resources =  new BookResource(dataStore, new DrillOneConfiguration());


    @Before
    public void setup() {
        dataStore.mockList();

    }

    @Test
    public void testUpdateViewToCheckIfBookDetailsGetChanged(){
        Book book = dataStore.getBookById(1);
        int id = book.getId();
        String author = book.getAuthor();
        String ISBNTen = book.getISBNTen();
        String ISBNThirteen = book.getISBNThirteen();

        resources.doUpdate(1,"TestTitle","TestAuthor","1234567891","978-12345678915");
        assertTrue(author != book.getAuthor());
        assertTrue(ISBNTen != book.getISBNTen());
        assertTrue(ISBNThirteen != book.getISBNThirteen());

        }

    @Test
    public void checkForValidInputs(){
        try{
            BookUpdateView view = (BookUpdateView)resources.doUpdate(1,"","","","");

            assertTrue(view.getErrors().size() > 0);

        }catch(Exception e){
            e.printStackTrace();

        }
    }

    @Test
    public void checkISBNFormatting(){
        assertTrue(resources.checkISBNFormatting("1234567891","978-12345678914"));
        assertFalse(resources.checkISBNFormatting("000000000","978-000000002"));
    }





    }



