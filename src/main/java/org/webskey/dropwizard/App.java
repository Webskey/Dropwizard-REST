package org.webskey.dropwizard;

import org.webskey.dropwizard.resources.TestResource;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment; 

public class App extends Application<Configuration> {
    
	@Override
	public void run(Configuration c, Environment e) throws Exception {
		e.jersey().register(new TestResource());
	}

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}
}