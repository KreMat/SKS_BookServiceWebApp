/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.jboss.ejb3.annotation.SecurityDomain;

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
@SecurityDomain("BookServiceWebAppSD")
@Transactional(rollbackOn = Exception.class)
public class BookService {

	@PersistenceContext
	private EntityManager em;

	@RolesAllowed("BSRead")
	public List<Book> getAllBooks() {
		return em.createNamedQuery("Book.selectAll", Book.class).getResultList();
	}

	@RolesAllowed("BSRead")
	public List<Book> findBooksByTitle(String title) {
		return em.createNamedQuery("Book.selectByTitle", Book.class).setParameter("title", title).getResultList();
	}

	@RolesAllowed("BSWrite")
	public void importBooks(List<Book> books) throws AuthorNotFoundException, PublisherNotFoundException {
		for (Book b : books) {
			loadAuthors(b);
			loadPublisher(b);
			em.persist(b);
		}
	}

	private void loadPublisher(Book b) throws PublisherNotFoundException {
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

	private void loadAuthors(Book b) throws AuthorNotFoundException {
		if (b == null || b.getAuthors() == null) {
			return;
		}
		List<Author> readAuthors = new ArrayList<Author>();
		for (Author a : b.getAuthors()) {
			readAuthors.add(loadAuthor(a));
		}
		b.setAuthors(readAuthors);
	}

	private Author loadAuthor(Author a) throws AuthorNotFoundException {
		try {
			return em.createNamedQuery("Author.selectByFirstAndLastname", Author.class)
					.setParameter("firstname", a.getFirstname()).setParameter("lastname", a.getLastname())
					.getSingleResult();
		} catch (NoResultException e) {
			throw new AuthorNotFoundException();
		}
	}
}
