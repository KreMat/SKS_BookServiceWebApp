/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.service;

import java.util.ArrayList;
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
			checkAuthorsExist(b);
			checkPublisher(b);
			em.persist(b);
		}
	}

	private void checkPublisher(Book b)
			throws PublisherNotFoundException {
		if (b == null || b.getPublisher() == null) {
			return;
		}
		List<Publisher> publisherRead = em.createNamedQuery("Publisher.selectByName", Publisher.class)
				.setParameter("name", b.getPublisher().getName()).getResultList();
		if (publisherRead == null || publisherRead.isEmpty()) {
			throw new PublisherNotFoundException();
		}
		b.setPublisher(publisherRead.get(0));
	}

	private void checkAuthorsExist(Book b)
			throws AuthorNotFoundException {
		if (b == null || b.getAuthors() == null) {
			return;
		}
		List<Author> readAuthors = new ArrayList<Author>();
		for (Author a : b.getAuthors()) {
			readAuthors.add(checkAuthorExist(a));
		}
		b.setAuthors(readAuthors);
	}

	private Author checkAuthorExist(Author a) throws AuthorNotFoundException {
		Author authorRead = em.createNamedQuery("Author.selectByFirstAndLastname", Author.class)
				.setParameter("firstname", a.getFirstname())
				.setParameter("lastname", a.getLastname())
				.getSingleResult();
		if (authorRead == null) {
			throw new AuthorNotFoundException();
		}
		return authorRead;
	}
}
