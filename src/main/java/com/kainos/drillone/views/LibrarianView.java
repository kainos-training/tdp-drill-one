package com.kainos.drillone.views;
import com.kainos.drillone.models.Book;
import io.dropwizard.views.View;

import java.util.List;

public class LibrarianView extends View {

    private final List<Book> books;

    public LibrarianView(List<Book> books) {
        super("/Views/book/book.ftl");
        this.books =books;
    }

    public List<Book> getBooks(){
        return books;
    }
}
