package at.wien.technikum.winterhalderkreuzriegler.sks.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Book;
import at.wien.technikum.winterhalderkreuzriegler.sks.exception.AuthorNotFoundException;
import at.wien.technikum.winterhalderkreuzriegler.sks.exception.PublisherNotFoundException;
import at.wien.technikum.winterhalderkreuzriegler.sks.webservice.dto.BookDto;

@WebService
public interface BookSOAPWebService {

	@WebMethod
	public List<BookDto> getAllBookDtos();

	@WebMethod
	public void importBooks(List<Book> book) throws AuthorNotFoundException,
			PublisherNotFoundException;

	@WebMethod
	public List<Book> findBooksByTitle(String title);

}
