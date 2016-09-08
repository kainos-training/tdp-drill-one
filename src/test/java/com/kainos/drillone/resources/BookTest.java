package com.kainos.drillone.resources;


import com.kainos.drillone.models.Book;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class BookTest {


//    @Test
//    public void bookTest(){
//        Book book = new Book();
//        String bookLink =book.getBookImageLink();
//        assertTrue(bookLink.equals("/assets/images/default.png"));
//    }

    @Test
    public void bookTestConstructorImageEmpty(){
        Book book = new Book(1,"title", "Aoife", "Finnegan", "1234567890", "978-1234567890*", "");
        String bookLink =book.getBookImageLink();
        System.out.print(bookLink);
        assertTrue(bookLink.equals("/assets/images/default.png"));
    }
    @Test
    public void bookTestConstructorImage(){
        Book book = new Book(1,"title", "Aoife", "Finnegan", "1234567890", "978-1234567890*", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQJRZVC8ugPTZ-Jy3FsVJpIoS0JzvEqbRZ_pnL4OBE5WW_6Xdp_");
        String bookLink =book.getBookImageLink();
        assertTrue(bookLink.equals("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQJRZVC8ugPTZ-Jy3FsVJpIoS0JzvEqbRZ_pnL4OBE5WW_6Xdp_"));
    }


}
