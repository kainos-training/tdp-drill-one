package com.kainos.drillone.views;

import io.dropwizard.views.View;

import java.util.List;

public class BookAddView extends View {

    private final List<String> errors;

    public BookAddView(List<String> errors) {
        super("/Views/book/add.ftl");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}