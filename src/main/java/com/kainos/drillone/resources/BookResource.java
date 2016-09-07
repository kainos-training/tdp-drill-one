package com.kainos.drillone.resources;
import com.codahale.metrics.annotation.Timed;
import com.kainos.drillone.DataStore;
import com.kainos.drillone.config.DrillOneConfiguration;
import com.kainos.drillone.views.LibrarianView;
import io.dropwizard.views.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("")
public class BookResource {

    final DataStore dataStore;
    final DrillOneConfiguration configuration;

    public BookResource(DataStore dataStore, DrillOneConfiguration configuration){
        this.dataStore=dataStore;
        this.configuration=configuration;
    }



    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)
    public View LibrarianView(){
        return new LibrarianView(dataStore.getBooks());
    }



}
