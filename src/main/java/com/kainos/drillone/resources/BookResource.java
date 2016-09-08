package com.kainos.drillone.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Lists;
import com.kainos.drillone.DataStore;
import com.kainos.drillone.config.DrillOneConfiguration;
import com.kainos.drillone.models.Book;
import com.kainos.drillone.views.BookUpdateView;
import com.kainos.drillone.views.LibrarianView;
import io.dropwizard.views.View;
import org.assertj.core.util.Strings;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.joda.time.DateTime;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by williamst on 07/09/2016.
 */

@Path("books")
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
                         @FormDataParam("authorFirstName") String authorFname,
                         @FormDataParam("authorSurname") String authorLname,
                         @FormDataParam("ISBNTen") String ISBNTen,
                         @FormDataParam("ISBNThirteen") String ISBNThirteen){

        System.out.println(id + title + authorFname + ISBNTen + ISBNThirteen);
        Book updatedBook = dataStore.getBookById(id);

        List<String> errors = Lists.newArrayList();

        if(!Strings.isNullOrEmpty(authorFname) && !Strings.isNullOrEmpty(authorLname)
                && !Strings.isNullOrEmpty(title)) {
            updatedBook.setAuthorFirstName(authorFname);
            updatedBook.setAuthorSurname(authorLname);
            updatedBook.setTitle(title);
        }else{
            errors.add("You must enter a Title and Author");
        }

        //If 1 ISBN is entered, add that ISBN.
        if(!Strings.isNullOrEmpty(ISBNTen) ^ !Strings.isNullOrEmpty(ISBNThirteen)) {
            updatedBook.setIsbnTen(ISBNTen);
            updatedBook.setIsbnThirteen(ISBNThirteen);
        } else {
            //If two ISBNs are entered, make sure they match
            if(!Strings.isNullOrEmpty(ISBNTen) && !Strings.isNullOrEmpty(ISBNThirteen)){
                if(checkISBNFormatting(ISBNTen, ISBNThirteen)){
                    updatedBook.setIsbnTen(ISBNTen);
                    updatedBook.setIsbnThirteen(ISBNThirteen);
                } else {errors.add("Your ISBN numbers don't match.");}
            //If none are entered, make sure user is alerted to enter one.
            } else {
                errors.add("You must enter at least one form of ISBN");
            }
        }
        if(!errors.isEmpty()){
            return new BookUpdateView(errors, updatedBook);
        }

        updatedBook.setLastModified(DateTime.now());

        URI bookListUri = UriBuilder.fromUri("/books/librarian").build();
        Response response = Response.seeOther(bookListUri).build();
        throw new WebApplicationException(response);
    }

    public Boolean checkISBNFormatting(String ISBNTen, String ISBNThirteen){
        if( (ISBNTen.length() != 10) || (ISBNThirteen.length() != 15)){return false;}
        if(ISBNThirteen.matches("978-" + ISBNTen + "[0-9]")){
            return true;
        }else{
            return false;
        }
    }

    @GET
    @Timed
    @Path("librarian")
    @Produces(MediaType.TEXT_HTML)
    public View LibrarianView(){

        List<Book> books = dataStore.getBooks();
        return new LibrarianView(books);
    }
}
