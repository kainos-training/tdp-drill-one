package com.kainos.drillone.views;

import io.dropwizard.views.View;

import java.util.List;

public class BookBorrowView extends View {

    private final List<String> errors;

    public BookBorrowView(List<String> errors) {
        super("/Views/Book/borrow.ftl");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}