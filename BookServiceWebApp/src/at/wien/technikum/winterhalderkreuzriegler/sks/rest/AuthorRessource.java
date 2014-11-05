package at.wien.technikum.winterhalderkreuzriegler.sks.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Author;
import at.wien.technikum.winterhalderkreuzriegler.sks.service.AuthorService;

@Path("news")
public class AuthorRessource {
	@PersistenceContext
	EntityManager em;
	
	@Inject
	AuthorService service;
	
	@GET
	@Path("/{authorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Author getAuthorAsJSON(@PathParam("newsId") long newsId){
		//return service.get;
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Author> getAllAuthorsAsJSON(){
		//return service.getAllNews();
		return null;
	}
}
