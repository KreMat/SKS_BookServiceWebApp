/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Author;
import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Book;
import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Publisher;
import at.wien.technikum.winterhalderkreuzriegler.sks.exception.AuthorNotFoundException;
import at.wien.technikum.winterhalderkreuzriegler.sks.exception.PublisherNotFoundException;

/**
 * @author Richard and Matthias
 *
 */
@Stateless(name = "bookservice")
@LocalBean
public class BookService {

	@PersistenceContext
	private EntityManager em;

	public List<Book> getAllBooks() {
		return em.createNamedQuery("Book.selectAll", Book.class)
				.getResultList();
	}

	public List<Book> findBooksByTitle(String title) {
		return em.createNamedQuery("Book.selectByTitle", Book.class)
				.setParameter("title", title).getResultList();
		// query.setParameter("title", title);
		// return query.getResultList();
	}

	public void importBooks(List<Book> books) throws AuthorNotFoundException,
			PublisherNotFoundException {
		for (Book b : books) {
			checkAuthorsExist(b.getAuthors());
			checkPublisher(b.getPublisher());
			em.persist(b);
		}
	}

	private void checkPublisher(Publisher publisher)
			throws PublisherNotFoundException {
		if (publisher == null) {
			return;
		}
		List<Publisher> publisherRead = em.createNamedQuery("Publisher.selectByName", Publisher.class)
				.setParameter("name", publisher.getName()).getResultList();
		if (publisherRead == null || publisherRead.isEmpty()) {
			throw new PublisherNotFoundException();
		}
	}

	private void checkAuthorsExist(List<Author> authors)
			throws AuthorNotFoundException {
		if (authors == null) {
			return;
		}
		for (Author a : authors) {
			checkAuthorExist(a);
		}

	}

	private void checkAuthorExist(Author a) throws AuthorNotFoundException {
		List<Author> authorsRead = em.createNamedQuery("Author.selectByFirstAndLastname", Author.class)
				.setParameter("firstname", a.getFirstname())
				.setParameter("lastname", a.getLastname())
				.getResultList();
		if (authorsRead == null || authorsRead.isEmpty()) {
			throw new AuthorNotFoundException();
		}
	}
}
