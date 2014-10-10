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
		TypedQuery<Book> query = em.createNamedQuery("Book.selectByTitle",
				Book.class);
		query.setParameter("title", title);
		return query.getResultList();
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
		Publisher publisherRead = em.find(Publisher.class, publisher.getId());
		if (publisherRead == null) {
			throw new PublisherNotFoundException();
		}
	}

	private void checkAuthorsExist(List<Author> authors)
			throws AuthorNotFoundException {
		for (Author a : authors) {
			checkAuthorExist(a);
		}

	}

	private void checkAuthorExist(Author a) throws AuthorNotFoundException {
		Author author = em.find(Author.class, a.getId());
		if (author == null) {
			throw new AuthorNotFoundException();
		}
	}
}
