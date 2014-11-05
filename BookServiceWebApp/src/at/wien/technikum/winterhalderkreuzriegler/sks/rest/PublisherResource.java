package at.wien.technikum.winterhalderkreuzriegler.sks.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Publisher;
import at.wien.technikum.winterhalderkreuzriegler.sks.service.PublisherService;

@Path("publisher")
@Produces(MediaType.APPLICATION_JSON)
public class PublisherResource {
	
	@Inject
	PublisherService service;
	
	@GET
	public List<Publisher> getAllPublisher(){
		return service.getAllPublisher();
	}
	
	@GET
	@Path("/{publisherId}")
	public Publisher getPublisherById(@PathParam("publisherId") long publisherId){
		return service.getPublisherById(publisherId);
	}
	
	@POST
	@Path("/{publisher}")
	public void createPublisher(@PathParam("publisher") Publisher publisher){
		service.createPublisher(publisher);
	}
	
	@PUT
	@Path("/{publisher}")
	public void updatePublisher(@PathParam("publisher") Publisher publisher){
		service.updatePublisher(publisher);
	}
	
	@DELETE
	@Path("/{publisherId}")
	public void createPublisher(@PathParam("publisherId") long publisherId){
		service.deletePublisher(publisherId);
	}
}