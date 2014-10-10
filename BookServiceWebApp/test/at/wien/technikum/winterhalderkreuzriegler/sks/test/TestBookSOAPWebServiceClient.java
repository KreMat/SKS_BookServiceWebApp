package at.wien.technikum.winterhalderkreuzriegler.sks.test;

import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Service;

import org.junit.Test;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Book;
import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Publisher;
import at.wien.technikum.winterhalderkreuzriegler.sks.enums.Language;
import at.wien.technikum.winterhalderkreuzriegler.sks.exception.PublisherNotFoundException;
import at.wien.technikum.winterhalderkreuzriegler.sks.webservice.BookSOAPWebService;

public class TestBookSOAPWebServiceClient {

	@Test
	public void testImport() throws Exception {
		URL wsdl = new URL(
				"http://localhost:8085/BookServiceWebApp/BookSOAPWebServiceImpl?wsdl");
		QName serviceName = new QName(
				"http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/",
				"BookSOAPWebServiceImplService");

		Service service = Service.create(wsdl, serviceName);
		BookSOAPWebService port = service.getPort(BookSOAPWebService.class);

		System.out.println("Books:");
		
		Publisher p = new Publisher();
		p.setId(1);
		Book b = new Book();
		b.setIsbn("abc123");
		b.setTitle("meinTitel");
		b.setSubtitle("meinUntertitel");
		b.setDescription("das ist ein tolles buch");
		b.setPages(30);
		b.setLanguage(Language.DE);
		b.setPublisher(p);	
		
		port.importBooks(Arrays.asList(b));
	}
	
	@Test(expected = SOAPException.class)
	public void testImportWithWrongPublisherFailed() throws Exception {
		URL wsdl = new URL(
				"http://localhost:8085/BookServiceWebApp/BookSOAPWebServiceImpl?wsdl");
		QName serviceName = new QName(
				"http://webservice.sks.winterhalderkreuzriegler.technikum.wien.at/",
				"BookSOAPWebServiceImplService");

		Service service = Service.create(wsdl, serviceName);
		BookSOAPWebService port = service.getPort(BookSOAPWebService.class);

		System.out.println("Books:");
		
		Publisher p = new Publisher();
		p.setId(10000);
		Book b = new Book();
		b.setIsbn("abc123");
		b.setTitle("meinTitel");
		b.setSubtitle("meinUntertitel");
		b.setDescription("das ist ein tolles buch");
		b.setPages(30);
		b.setLanguage(Language.DE);
		b.setPublisher(p);	
		
		port.importBooks(Arrays.asList(b));
	}
}
