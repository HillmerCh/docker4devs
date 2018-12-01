package cafe.web.rest;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.List;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("hello")
public class RestResource {

	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> numbers() {
		return Arrays.asList(1L,2L,3L,4L,5L);
	}




}