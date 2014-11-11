package at.wien.technikum.winterhalderkreuzriegler.sks.client;

import java.text.ParseException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import at.wien.technikum.winterhalderkreuzriegler.sks.client.dto.PublisherDto;

public class CommandLineClientCreatePublisher {

	public static void main(String[] args) throws ParseException {

		if (args.length != 3) {
			throw new IllegalArgumentException("Usage: "
					+ CommandLineClientCreatePublisher.class.getSimpleName()
					+ " name postcode countrycode");
		}

		PublisherDto p = new PublisherDto(args[0], args[1], args[2]);

		ClientBuilder
				.newClient()
				.target("http://localhost:8085/BookServiceWebApp/resources/publisher")
				.request(MediaType.APPLICATION_JSON).post(Entity.json(p));

		System.out.println("Import erfolgreich abgeschlossen...");
	}

}
