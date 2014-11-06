/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Author;

/**
 * @author Richard and Matthias
 *
 */
@Stateless(name = "authorservice")
@LocalBean
public class AuthorService {

	@PersistenceContext
	private EntityManager em;

	public List<Author> getAllAuthors() {
		return em.createNamedQuery("Author.selectAll", Author.class)
				.getResultList();
	}

	public Author getAuthorById(long id) {
		return em.find(Author.class, id);
	}

	public void createAuthor(Author author) {
		em.persist(author);
	}

	public void updateAuthor(Author author) {
		em.merge(author);
	}

	public void deleteAuthor(long id) {
		em.remove(id);
	}

}
