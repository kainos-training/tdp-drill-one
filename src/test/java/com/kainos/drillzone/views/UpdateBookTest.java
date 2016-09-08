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

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by williamst on 07/09/2016.
 */
public class UpdateBookTest {
    public DataStore dataStore;
    BookResource resources;


    @Before
    public void setup() {
        dataStore = mock(DataStore.class);
        resources =  new BookResource(dataStore, new DrillOneConfiguration());
    }

    @Test(expected = WebApplicationException.class)
    public void testUpdateViewToCheckIfBookDetailsGetChanged(){

        List<Book> books = new ArrayList<Book>();

        Book booklet1 = new Book(1, "Jer", "person", "lol", "haha", "143");
        Book booklet2 = new Book(2, "Laddy", "McSass", "A Good Day on the Beach", "10374123423", "1430723409723");
        Book booklet3 = new Book(3, "Franco","Manca", "Dank Kush: a Love Story", "103741234345", "1435289362923");
        books.add(booklet1);
        books.add(booklet2);
        books.add(booklet3);

        when(dataStore.getBooks()).thenReturn(books);
        when(dataStore.getBookById(1)).thenReturn(booklet1);


        Book book = dataStore.getBookById(1);
        int id = book.getId();
        String authorFname = book.getAuthorFirstName();
        String authorLname = book.getAuthorSurname();
        String ISBNTen = book.getIsbnTen();
        String ISBNThirteen = book.getIsbnThirteen();

        resources.doUpdate(1,"TestTitle","TestFname", "TestLname","1234567891","978-12345678915");
        assertTrue(authorFname != book.getAuthorFirstName());
        assertTrue(authorLname != book.getAuthorSurname());
        assertTrue(ISBNTen != book.getIsbnTen());
        assertTrue(ISBNThirteen != book.getIsbnThirteen());

        }

    @Test
    public void checkForValidInputs(){
        try{
            BookUpdateView view = (BookUpdateView)resources.doUpdate(1,"","","","","");

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



