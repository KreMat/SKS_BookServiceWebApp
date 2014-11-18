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

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Author;
import at.wien.technikum.winterhalderkreuzriegler.sks.service.AuthorService;

@Path("author")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource {

	@Inject
	AuthorService service;

	@Context
	UriInfo ui;

	@GET
	public List<Author> getAllAuthors() {
		return service.getAllAuthors();
	}

	@GET
	@Path("/{authorId}")
	public Author getAuthorById(@PathParam("authorId") long authorId) {
		return service.getAuthorById(authorId);
	}

	@POST
	public Response createAuthor(Author author) {
		service.createAuthor(author);

		URI authorURI = ui.getAbsolutePathBuilder().path(String.valueOf(author.getId())).build();
		return Response.created(authorURI).build();
	}

	@PUT
	@Path("/{authorId}")
	public void updateAuthor(@PathParam("authorId") long authorId, Author author) {
		author.setId(authorId);
		service.updateAuthor(author);
	}

	@DELETE
	@Path("/{authorId}")
	public void createAuthor(@PathParam("authorId") long authorId) {
		service.deleteAuthor(authorId);
	}
}
