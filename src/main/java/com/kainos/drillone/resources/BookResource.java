package com.kainos.drillone.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Lists;
import com.kainos.drillone.DataStore;
import com.kainos.drillone.views.BookAddView;
import com.kainos.drillone.views.PeopleAddView;
import com.kainos.drillone.views.PeopleListView;
import com.kainos.drillone.config.DrillOneConfiguration;
import io.dropwizard.views.View;
import org.assertj.core.util.Strings;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("/book")
public class BookResource {

    final static Logger LOGGER = LoggerFactory.getLogger(BookResource.class);

    final DataStore dataStore;
    final DrillOneConfiguration configuration;

    public BookResource(DataStore dataStore, DrillOneConfiguration configuration) {
        this.dataStore = dataStore;
        this.configuration = configuration;
    }


    @Path("/add")
    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View add(){
        return new BookAddView(new ArrayList<String>());
    }

    @Path("/add")
    @POST
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public View addBook(
            @FormDataParam("title") String title,
            @FormDataParam("authorFirstName") String authorFirstName,
            @FormDataParam("authorLastName") String authorLastName,
            @FormDataParam("ISBN10") String ISBN10,
            @FormDataParam("ISBN13") String ISBN13
    ){

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

        UUID idForNewPerson = UUID.randomUUID();

        LOGGER.info("Adding book " + String.format("title: %s author first name: %s author last name: %s ISBN10: %s ISBN13: %s", title, authorFirstName, authorLastName, ISBN10, ISBN13));
        dataStore.addBook(title, authorFirstName, authorLastName, ISBN10, ISBN13);

        URI bookListUri = UriBuilder.fromUri("/book").build();
        Response response = Response.seeOther(bookListUri).build();
        throw new WebApplicationException(response); // valid way to redirect in dropwizard
    }
}