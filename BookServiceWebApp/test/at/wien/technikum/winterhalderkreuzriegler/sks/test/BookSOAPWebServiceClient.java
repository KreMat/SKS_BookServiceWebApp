package at.wien.technikum.winterhalderkreuzriegler.sks.test;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import at.wien.technikum.winterhalderkreuzriegler.sks.webservice.BookSOAPWebService;

public class BookSOAPWebServiceClient {

	public static void main(String[] args) throws Exception {
		URL wsdl = new URL(
				"http://localhost:8085/BookServiceWebApp/BookSOAPWebServiceImpl?wsdl");
		QName serviceName = new QName(
				"http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/",
				"BookSOAPWebServiceImplService");

		Service service = Service.create(wsdl, serviceName);
		BookSOAPWebService port = service.getPort(BookSOAPWebService.class);

		System.out.println("Books:");
		port.getAllBookDtos().forEach(System.out::println);
	}
}
