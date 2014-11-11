package at.wien.technikum.winterhalderkreuzriegler.sks.client;

import java.text.ParseException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import at.wien.technikum.winterhalderkreuzriegler.sks.client.dto.AuthorDto;

public class CommandLineClientCreateAuthor {

	public static void main(String[] args) throws ParseException {

		if (args.length != 3) {
			throw new IllegalArgumentException("Usage: "
					+ CommandLineClientCreateAuthor.class.getSimpleName()
					+ " firstname lastname birthday (yyyy-MM-dd)");
		}
		
		AuthorDto a = new AuthorDto(args[0], args[1], args[2]);

		ClientBuilder
				.newClient()
				.target("http://localhost:8085/BookServiceWebApp/resources/author")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(a));


		System.out.println("Import erfolgreich abgeschlossen...");
	}

}
