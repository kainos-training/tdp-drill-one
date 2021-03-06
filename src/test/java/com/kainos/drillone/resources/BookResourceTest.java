
package com.kainos.drillone.resources;

import com.kainos.drillone.DataStore;
import com.kainos.drillone.config.DrillOneConfiguration;
import com.kainos.drillone.models.Book;
import com.kainos.drillone.views.BookAddView;
import com.kainos.drillone.views.LibrarianView;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.WebApplicationException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by christopherg on 07/09/2016.
 */
public class BookResourceTest {
    private DrillOneConfiguration configuration;
    private DataStore dataStore;
    private BookResource resource;

    @Before
    public void setup(){
        configuration = new DrillOneConfiguration();
        dataStore = mock(DataStore.class);
        resource = new BookResource(dataStore, configuration);
    }
    @Test
    public void Index_WhenCalledForEmptyList_ReturnsViewWithEmptyList(){
        when(dataStore.getBooks()).thenReturn(new ArrayList<Book>());
        LibrarianView view = (LibrarianView)resource.LibrarianView();
        verify(dataStore).getBooks();
        assertEquals(view.getLibrary().size(), 0);
        assertEquals("/Views/book/books.ftl", view.getTemplateName());
    }
    @Test
    public void Index_WhenCalledForEmptyList_ReturnsViewWithPopulatedList(){
        List<Book> books = new ArrayList<Book>();
        Book book = new Book();
        book.setIsbnTen("1234567890");
        book.setIsbnThirteen("1234567890123");
        book.setTitle("programming 101");
        book.setAuthorFirstName("chris");
        book.setAuthorSurname("gill");
        book.setId(1);
        books.add(book);
        book = new Book();
        book.setIsbnTen("1234567540");
        book.setIsbnThirteen("12345as790123");
        book.setTitle("agile 101");
        book.setAuthorFirstName("chris");
        book.setAuthorSurname("gill");
        book.setId(2);
        books.add(book);
        when(dataStore.getBooks()).thenReturn(books);
        LibrarianView view = (LibrarianView)resource.LibrarianView();
        verify(dataStore).getBooks();
        assertEquals(view.getLibrary().size(), 2);
        assertEquals("1234567540", books.get(1).getIsbnTen());
        assertEquals("12345as790123", books.get(1).getIsbnThirteen());
        assertEquals("agile 101", books.get(1).getTitle());
        assertEquals("chris", books.get(1).getAuthorFirstName());
        assertEquals("gill", books.get(1).getAuthorSurname());
        assertEquals(2, books.get(1).getId());
        assertEquals("/Views/book/books.ftl", view.getTemplateName());
    }

    @Test
    public void AddBook_WhenTitleEmpty_ReturnsToBookAddView(){
        List<String> errors = Lists.newArrayList();
        assertThat(resource.AddBook("", "Aoife", "Finnegan", "1234567890", "978-1234567890*"), is(instanceOf(BookAddView.class)));
    }

    @Test(expected = WebApplicationException.class)
    public void AddBook_WhenCorrectDetailsEntered_WebApplicationExceptionThrown() {
        resource.AddBook("Test", "Aoife", "Finnegan", "1234567890", "978-1234567890*");
    }
}
