package at.wien.technikum.winterhalderkreuzriegler.sks.client;

import java.text.ParseException;

import at.wien.technikum.winterhalderkreuzriegler.sks.client.dto.PublisherDto;
import at.wien.technikum.winterhalderkreuzriegler.sks.client.helper.JSONRequest;

public class CommandLineClientCreatePublisher {

	public static void main(String[] args) throws ParseException {

		if (args.length != 3) {
			throw new IllegalArgumentException("Usage: "
					+ CommandLineClientCreatePublisher.class.getSimpleName()
					+ " name postcode countrycode");
		}

		PublisherDto p = new PublisherDto(args[0], args[1], args[2]);

		JSONRequest.sendJSONRequest(
				"http://localhost:8085/BookServiceWebApp/resources/publisher", p);

		System.out.println("Import erfolgreich abgeschlossen...");
	}

}
