package at.wien.technikum.winterhalderkreuzriegler.sks.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import at.wien.technikum.winterhalderkreuzriegler.sks.webservice.dto.BookDto;

@WebService
public interface BookSOAPWebService {

	@WebMethod
	public List<BookDto> getAllBooks();

}
