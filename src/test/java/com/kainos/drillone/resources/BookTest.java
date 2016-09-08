package com.kainos.drillone.resources;


import com.kainos.drillone.models.Book;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class BookTest {


    @Test
    public void bookTest(){
        Book book = new Book();
        String bookLink =book.getBookImageLink();
        assertTrue(bookLink.equals("https://images-na.ssl-images-amazon.com/images/I/51tjK8swIOL.jpg"));
    }

}
