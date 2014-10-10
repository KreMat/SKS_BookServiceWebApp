package at.wien.technikum.winterhalderkreuzriegler.sks.webservice;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

import org.apache.commons.beanutils.BeanUtils;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Book;
import at.wien.technikum.winterhalderkreuzriegler.sks.exception.AuthorNotFoundException;
import at.wien.technikum.winterhalderkreuzriegler.sks.exception.PublisherNotFoundException;
import at.wien.technikum.winterhalderkreuzriegler.sks.service.BookService;
import at.wien.technikum.winterhalderkreuzriegler.sks.webservice.dto.BookDto;

@WebService(endpointInterface = "at.wien.technikum.winterhalderkreuzriegler.sks.webservice.BookSOAPWebService")
public class BookSOAPWebServiceImpl implements BookSOAPWebService {

	@Inject
	private BookService bookService;

	@Override
	public List<BookDto> getAllBookDtos() {
		List<BookDto> list = new ArrayList<BookDto>();
		for (Book book : bookService.getAllBooks()) {
			BookDto dto = new BookDto();
			try {
				BeanUtils.copyProperties(dto, book);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
				return null;
			}
			list.add(dto);
		}
		return list;
	}

	@Override
	public void importBooks(List<Book> books) throws AuthorNotFoundException,
			PublisherNotFoundException {
		bookService.importBooks(books);
	}

	@Override
	public List<Book> findBooksByTitle(String title) {
		return bookService.findBooksByTitle(title);
	}

}
