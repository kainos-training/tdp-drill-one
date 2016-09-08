/*
package com.kainos.drillone.resources;

import com.codahale.metrics.MetricRegistry;
import com.google.common.collect.Lists;
import com.kainos.drillone.DataStore;
import com.kainos.drillone.config.DrillOneConfiguration;
import io.dropwizard.testing.junit.ResourceTestRule;
import io.dropwizard.views.ViewMessageBodyWriter;
import io.dropwizard.views.ViewRenderer;
import io.dropwizard.views.freemarker.FreemarkerViewRenderer;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookResourceTest {

    private static List<ViewRenderer> renders = Lists.<ViewRenderer>newArrayList(new FreemarkerViewRenderer());
    private BookResource bookResource = new BookResource(new DataStore(), new DrillOneConfiguration());

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new com.kainos.drillone.resources.BookResource(new DataStore(), new DrillOneConfiguration()))
            .addProvider(new ViewMessageBodyWriter(new MetricRegistry(), renders))
            .build();

    @Before
    public void setup() {
    }

    @Test
    public void testAdd() {
        Response response = resources.client()
                .target("/book/add")
                .request(MediaType.TEXT_HTML_TYPE)
                .get();

        assertEquals(200, response.getStatus());
    }

    @Test
    public void testEmptyTitleReturnsError(){
        bookResource.addBook("", "Aoife", "Finnegan", "1234567890", "1234567890123");
    }
} */