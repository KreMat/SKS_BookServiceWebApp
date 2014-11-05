package at.wien.technikum.winterhalderkreuzriegler.sks.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Author;
import at.wien.technikum.winterhalderkreuzriegler.sks.service.AuthorService;

@Path("author")
public class AuthorRessource {
	
	@Inject
	AuthorService service;
	
	@GET
	@Path("/{authorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Author getAuthorAsJSON(@PathParam("authorId") long authorId){
		return service.getAuthorById(authorId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Author> getAllAuthorsAsJSON(){
		return service.getAllAuthors();
	}
}
