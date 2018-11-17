package org.webskey.dropwizard.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.webskey.dropwizard.dao.TestDao;

@Path("/test")
@Produces(MediaType.TEXT_PLAIN)
public class TestResource {

	private TestDao testDao;
	
	public TestResource(TestDao testDao) {
		this.testDao = testDao;
	}
	
	@GET
	public String test() {
		return "Test  passed positively";
	}
	
	@GET
	@Path("/db")
	public String databse() {
		return testDao.findById(1);
	}
}
