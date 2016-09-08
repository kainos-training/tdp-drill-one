package BookTests;

import com.kainos.drillone.DataStore;
import com.kainos.drillone.config.DrillOneConfiguration;
import com.kainos.drillone.resources.BookResource;
import com.kainos.drillone.views.BookAddView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class BookAddViewTest {
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
    public void AddBook_WhenBookTitleEmpty_ReturnsEmptyTitleError(){
        List<String> errors = org.assertj.core.util.Lists.newArrayList();
        errors.add("Enter a valid book title");
        BookAddView resultView = (BookAddView)bookResource.AddBook("", "Aoife", "Finnegan", "1234567890", "978-1234567890*", "");


        Assert.assertEquals(errors, resultView.getErrors());
    }


}
