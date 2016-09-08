package BookTests;

import com.google.common.collect.Lists;
import com.kainos.drillone.DataStore;
import com.kainos.drillone.config.DrillOneConfiguration;
import com.kainos.drillone.models.Book;
import com.kainos.drillone.resources.BookResource;
import com.kainos.drillone.views.LibrarianView;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibrarianViewTest {
    private DataStore dataStore;
    private DrillOneConfiguration configuration;
    private BookResource bookResource;

    @Before
    public void setUp() {
        dataStore = new DataStore();
        configuration = new DrillOneConfiguration();
        bookResource = new BookResource(dataStore, configuration);
    }

    @Test
    public void returnLibrarianView() {
        assertThat(bookResource.LibrarianView(), is(instanceOf(LibrarianView.class)));
    }

    private List<Book> addBooks() {
         List<Book> books = Lists.newArrayList();
        Book book = new Book();
        book.setIsbnTen("test");
        book.setIsbnThirteen("t est asd");
        book.setTitle("programming 101");
        book.setAuthorFirstName("chris");
        book.setAuthorSurname("gill");
        book.setId(1);
        books.add(book);
        book = new Book();
        book.setIsbnTen("isbn10");
        book.setIsbnThirteen("isbn13");
        book.setTitle("programming 102");
        book.setAuthorFirstName("claire");
        book.setAuthorSurname("houston");
        book.setId(2);
        books.add(book);
        return books;
    }


}
