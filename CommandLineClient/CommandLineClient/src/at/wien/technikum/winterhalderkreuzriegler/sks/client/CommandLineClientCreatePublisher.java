package at.wien.technikum.winterhalderkreuzriegler.sks.client;

import java.text.ParseException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import at.wien.technikum.winterhalderkreuzriegler.sks.client.dto.PublisherDto;

public class CommandLineClientCreatePublisher {

	public static void main(String[] args) throws ParseException {

		if (args.length != 3) {
			throw new IllegalArgumentException("Usage: "
					+ CommandLineClientCreatePublisher.class.getSimpleName()
					+ " name postcode countrycode");
		}

		PublisherDto p = new PublisherDto(args[0], args[1], args[2]);

		Response response = ClientBuilder
				.newClient()
				.target("http://localhost:8085/BookServiceWebApp/resources/publisher")
				.register(new RequestFilter("writer", "123"))
				.request(MediaType.APPLICATION_JSON).post(Entity.json(p));
		
		if(response.getStatus() != 200){
			System.out.println("Import mit Status: " + response.getStatus() + " - " + response.getStatusInfo().getReasonPhrase());	
		}else{
			System.out.println("Import erfolgreich abgeschlossen...");
		}

		
		
	}

}
