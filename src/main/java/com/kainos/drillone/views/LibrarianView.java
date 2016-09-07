package com.kainos.drillone.views;
import com.kainos.drillone.models.Book;
import io.dropwizard.views.View;

import java.util.List;

public class LibrarianView extends View {

    private final List<Book> bookList;

    public LibrarianView(List<Book> bookList) {
        super("/Views/book/book.ftl");
        this.bookList=bookList;
    }

    public List<Book> getBookList(){
        return bookList;
    }
}
