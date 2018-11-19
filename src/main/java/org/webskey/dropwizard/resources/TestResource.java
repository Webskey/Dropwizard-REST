package org.webskey.dropwizard.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.webskey.dropwizard.dao.TestDao;
import org.webskey.dropwizard.views.TestView;

@Path("/test")
public class TestResource {

	private TestDao testDao;
	
	public TestResource(TestDao testDao) {
		this.testDao = testDao;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Test  passed positively";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/db")
	public String databse() {
		return testDao.findById(1);
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/view")
	public TestView testView() {
		return new TestView();
	}
}
