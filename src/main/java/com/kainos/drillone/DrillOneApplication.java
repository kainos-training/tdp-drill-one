package com.kainos.drillone;

import com.kainos.drillone.config.DrillOneConfiguration;
import com.kainos.drillone.resources.BookResource;
import com.kainos.drillone.resources.HomeResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class DrillOneApplication extends Application<DrillOneConfiguration> {
    @Override
    public void initialize(Bootstrap<DrillOneConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<DrillOneConfiguration>());
        bootstrap.addBundle(new AssetsBundle("/assets", "/assets"));
        bootstrap.addBundle(new MultiPartBundle());
    }

    public void run(DrillOneConfiguration discoveryDiaryConfiguration, Environment environment) throws Exception {
        final HomeResource homeResource = new HomeResource();
        final BookResource bookResource=new BookResource(new DataStore(), discoveryDiaryConfiguration);

        environment.jersey().register(homeResource);
        environment.jersey().register(bookResource);
    }

    public static void main(String[] args) throws Exception {
        new com.kainos.drillone.DrillOneApplication().run(args);
    }
}
