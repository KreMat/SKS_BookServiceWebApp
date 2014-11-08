package at.wien.technikum.winterhalderkreuzriegler.sks.client;

import java.text.ParseException;

import at.wien.technikum.winterhalderkreuzriegler.sks.client.dto.AuthorDto;
import at.wien.technikum.winterhalderkreuzriegler.sks.client.helper.JSONRequest;

public class CommandLineClientCreateAuthor {

	public static void main(String[] args) throws ParseException {

		if (args.length != 3) {
			throw new IllegalArgumentException("Usage: "
					+ CommandLineClientCreateAuthor.class.getSimpleName()
					+ " firstname lastname birthday (yyyy-MM-dd)");
		}

		AuthorDto a = new AuthorDto(args[0], args[1], args[2]);

		JSONRequest.sendJSONRequest(
				"http://localhost:8085/BookServiceWebApp/resources/author", a);

		System.out.println("Import erfolgreich abgeschlossen...");
	}

}
