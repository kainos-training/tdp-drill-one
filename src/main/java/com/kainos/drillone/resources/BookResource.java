package com.kainos.drillone.resources;

import com.kainos.drillone.DataStore;
import com.kainos.drillone.config.DrillOneConfiguration;
import com.kainos.drillone.models.Book;
import com.kainos.drillone.views.BookUpdateView;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;

/**
 * Created by williamst on 07/09/2016.
 */

@Path("book")
public class BookResource {

    private final DataStore dataStore;

    final DrillOneConfiguration configuration;

    public BookResource(DataStore dataStore, DrillOneConfiguration configuration) {
        this.dataStore = dataStore;
        this.configuration = configuration;
        dataStore.mockList();
    }

    @Path("update")
    @GET
    public View Update(@QueryParam("id") int id){
        Book bookToUpdate = dataStore.getBookById(id);
        return new BookUpdateView(new ArrayList<String>(), bookToUpdate);
    }

}
