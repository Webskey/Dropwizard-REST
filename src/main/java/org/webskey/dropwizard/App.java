package org.webskey.dropwizard;

import org.jdbi.v3.core.Jdbi;
import org.webskey.dropwizard.dao.TestDao;
import org.webskey.dropwizard.healthchecks.DatabaseHealthCheck;
import org.webskey.dropwizard.resources.TestResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment; 

public class App extends Application<MyConfig> {
    
	@Override
	public void run(MyConfig c, Environment e) throws Exception {		
		final JdbiFactory factory = new JdbiFactory();
	    final Jdbi jdbi = factory.build(e, c.getDataSourceFactory(), "test-database");
	    final TestDao dao = jdbi.onDemand(TestDao.class);
	    
	    e.healthChecks().register("my database", new DatabaseHealthCheck(c.getDataSourceFactory()));	    
		e.jersey().register(new TestResource(dao));
	}

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}
}