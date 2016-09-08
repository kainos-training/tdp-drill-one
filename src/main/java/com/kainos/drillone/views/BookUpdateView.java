package com.kainos.drillone.views;

import com.kainos.drillone.models.Book;
import io.dropwizard.views.View;

import java.util.List;

public class BookUpdateView extends View {

    public final List<String> errors;
    private final Book book;

    public BookUpdateView(List<String> errors, Book book) {
        super("/Views/book/updateBook.ftl");
        this.errors = errors;
        this.book = book;
    }

    public List<String> getErrors() {
        return errors;
    }

    public Book getBook() {return book; }
}