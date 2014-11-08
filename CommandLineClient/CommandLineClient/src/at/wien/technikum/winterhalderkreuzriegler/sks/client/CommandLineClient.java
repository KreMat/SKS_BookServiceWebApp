package at.wien.technikum.winterhalderkreuzriegler.sks.client;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import at.technikumwien.sks.generated.Book;
import at.technikumwien.sks.generated.BookSOAPWebService;
import at.technikumwien.sks.generated.BookSOAPWebServiceImplService;
import at.technikumwien.sks.generated.SOAPException_Exception;
import at.wien.technikum.winterhalderkreuzriegler.sks.client.helper.Wrapper;

public class CommandLineClient {

	public static void main(String[] args) throws JAXBException, SOAPException_Exception{
		
		if(args.length != 1 || args[0].isEmpty()){
			throw new IllegalArgumentException("You need one argument with the xml path!");
		}

		BookSOAPWebServiceImplService service = new BookSOAPWebServiceImplService();
		BookSOAPWebService port = service.getBookSOAPWebServiceImplPort();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Wrapper.class, Book.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		List<Book> books = unmarshal(unmarshaller, Book.class, args[0]);
		
		port.importBooks(books);
		
		System.out.println("Import erfolgreich abgeschlossen...");
	}
	
	/**
     * Unmarshal XML to Wrapper and return List value.
     */
    private static <T> List<T> unmarshal(Unmarshaller unmarshaller,
            Class<T> clazz, String xmlLocation) throws JAXBException {
        StreamSource xml = new StreamSource(xmlLocation);
        Wrapper<T> wrapper = (Wrapper<T>) unmarshaller.unmarshal(xml,
                Wrapper.class).getValue();
        return wrapper.getItems();
    }
 
    /**
     * Wrap List in Wrapper, then leverage JAXBElement to supply root element 
     * information.
     */
    private static void marshal(Marshaller marshaller, List<?> list, String name)
            throws JAXBException {
        QName qName = new QName(name);
        Wrapper wrapper = new Wrapper(list);
        JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName,
                Wrapper.class, wrapper);
        marshaller.marshal(jaxbElement, System.out);
    }
	
}
