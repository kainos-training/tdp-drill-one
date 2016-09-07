package com.kainos.drillone.views;

import com.kainos.drillone.models.Book;
import io.dropwizard.views.View;

import java.util.List;

public class PeopleListView extends View {

    private final List<Book> people;

    public PeopleListView(List<Book> people) {
        super("/Views/people/list.ftl");
        this.people = people;
    }

    public List<Book> getPeople() {
        return people;
    }
}