package com.kainos.drillone.resources;

import com.google.common.collect.Lists;
import com.kainos.drillone.DataStore;
import com.kainos.drillone.config.DrillOneConfiguration;
import com.kainos.drillone.models.Book;
import com.kainos.drillone.views.BookUpdateView;
import io.dropwizard.views.View;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

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
    public View update(@QueryParam("id") int id){
        Book bookToUpdate = dataStore.getBookById(id);
        return new BookUpdateView(new ArrayList<String>(), bookToUpdate);
    }

    @Path("update")
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public View doUpdate(@FormDataParam("id") int id, @FormDataParam("title") String title,
                         @FormDataParam("author") String author, @FormDataParam("ISBNTen") String ISBNTen,
                         @FormDataParam("ISBNThirteen") String ISBNThirteen){

        System.out.println(id + title + author + ISBNTen + ISBNThirteen);
        Book updatedBook = dataStore.getBookById(id);
        List<String> errors = Lists.newArrayList();

        if(author != null && title != null) {
            updatedBook.setAuthor(author);
            updatedBook.setTitle(title);
        }else{
            errors.add("You must enter a Title and Author");
        }
        if(ISBNTen != null || ISBNThirteen != null) {
            updatedBook.setISBNTen(ISBNTen);
            updatedBook.setISBNThirteen(ISBNThirteen);
        }else{
            errors.add("You must enter at least one form of ISBN");
        }



        return new BookUpdateView(new ArrayList<String>(), updatedBook);
    }

}
