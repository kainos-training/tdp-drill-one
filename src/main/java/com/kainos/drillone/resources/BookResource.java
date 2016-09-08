package com.kainos.drillone.resources;

import com.codahale.metrics.annotation.Timed;
import com.kainos.drillone.DataStore;
import com.kainos.drillone.config.DrillOneConfiguration;
import com.kainos.drillone.models.Book;
import com.kainos.drillone.views.BookAddView;
import com.kainos.drillone.views.BookBorrowView;
import com.kainos.drillone.views.LibrarianView;
import io.dropwizard.views.View;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Strings;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@Path("books")
public class BookResource {

    final DataStore dataStore;
    final DrillOneConfiguration configuration;

    public BookResource(DataStore dataStore, DrillOneConfiguration configuration) {
        this.dataStore = dataStore;
        this.configuration = configuration;
    }

    @GET
    @Timed
    @Path("librarian")
    @Produces(MediaType.TEXT_HTML)
    public View LibrarianView(){

        List<Book> books = dataStore.getBooks();
        return new LibrarianView(books);
    }

    @Path("/borrow")
    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View BookBorrowView(){
        return new BookBorrowView(new ArrayList<String>());
    }

    @Path("/add")
    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View BookAddView(){
        return new BookAddView(new ArrayList<String>());
    }

    @Path("/addbook")
    @POST
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public View AddBook(
            @FormDataParam("title") String title,
            @FormDataParam("authorFirstName") String authorFirstName,
            @FormDataParam("authorLastName") String authorLastName,
            @FormDataParam("ISBN10") String ISBN10,
            @FormDataParam("ISBN13") String ISBN13
    ){
        List<String> errors = Validate(title, authorFirstName, authorLastName, ISBN10, ISBN13);
        Lists.newArrayList();

        if (!errors.isEmpty()) {
            return new BookAddView(errors);
        }

        dataStore.addBook(title, authorFirstName, authorLastName, ISBN10, ISBN13);

        URI bookListUri = UriBuilder.fromUri("/books/librarian").build();
        Response response = Response.seeOther(bookListUri).build();
        throw new WebApplicationException(response); // valid way to redirect in dropwizard
    }

    public List<String> Validate(String title, String authorFirstName, String authorLastName, String ISBN10, String ISBN13){
        List<String> errors = Lists.newArrayList();
        if (Strings.isNullOrEmpty(title)) {
            errors.add("Enter a valid book title");
        }

        if (Strings.isNullOrEmpty(authorFirstName)) {
            errors.add("Enter a valid author first name");
        }

        if (Strings.isNullOrEmpty(authorLastName)) {
            errors.add("Enter a valid author last name");
        }

        if (Strings.isNullOrEmpty(ISBN10) && Strings.isNullOrEmpty(ISBN13)) {
            errors.add("Enter at least one ISBN number");
        }

        if(!Strings.isNullOrEmpty(ISBN10)){
            if(ISBN10.length() != 10){
                errors.add("Enter a valid 10-digit ISBN");
            }
        }

        if(!Strings.isNullOrEmpty(ISBN13)){
            if(ISBN13.length() != 15){
                errors.add("Enter a valid 13-digit ISBN");
            } else {
                if(ISBN13.contains("-")){
                    String[] ISBNComponents = ISBN13.split("-");
                    if(ISBNComponents[0].equals("978") && ISBNComponents[1].length() == 11 && ISBNComponents[1].charAt(ISBNComponents[1].length()-1) == '*') {
                    } else {
                        errors.add("Enter a valid 13-digit ISBN");
                    }
                } else {
                    errors.add("Enter a valid 13-digit ISBN");
                }
            }
        }

        return errors;
    }

    @Path("/borrowbook")
    @POST
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public View Borrow(
            @FormDataParam("borrower") String borrower
    ){
        List<String> errors = Lists.newArrayList();

        if (!errors.isEmpty()) {
            return new BookBorrowView(errors);
        }

        //dataStore.addBook(title, authorFirstName, authorLastName, ISBN10, ISBN13);

        URI bookListUri = UriBuilder.fromUri("/books/librarian").build();
        Response response = Response.seeOther(bookListUri).build();
        throw new WebApplicationException(response); // valid way to redirect in dropwizard
    }
}

