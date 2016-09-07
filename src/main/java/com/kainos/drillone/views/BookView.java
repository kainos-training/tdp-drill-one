package com.kainos.drillone.views;

import com.kainos.drillone.models.Book;
import io.dropwizard.views.View;

import java.util.List;

public class BookView extends View {

    private final List<Book> library;

    public BookView(List<Book> people) {
        super("/Views/Book/books.ftl");
        this.library = people;
    }

    public List<Book> getLibrary() {
        return library;
    }
}