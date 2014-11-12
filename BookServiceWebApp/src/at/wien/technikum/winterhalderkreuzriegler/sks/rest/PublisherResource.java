package at.wien.technikum.winterhalderkreuzriegler.sks.rest;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Publisher;
import at.wien.technikum.winterhalderkreuzriegler.sks.service.PublisherService;

@Path("publisher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PublisherResource {
	
	@Inject
	PublisherService service;
	
	@Context
	UriInfo ui;
	
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
	public Response createPublisher(Publisher publisher){
		service.createPublisher(publisher);
		
		URI publisherURI = ui.getAbsolutePathBuilder().path(String.valueOf(publisher.getId())).build();	
		return Response.created(publisherURI).build();
	}
	
	@PUT
	@Path("/{publisherId}")
	public void updatePublisher(@PathParam("publisherId") long publisherId, Publisher publisher){
		publisher.setId(publisherId);
		service.updatePublisher(publisher);
	}
	
	@DELETE
	@Path("/{publisherId}")
	public void createPublisher(@PathParam("publisherId") long publisherId){
		service.deletePublisher(publisherId);
	}
}