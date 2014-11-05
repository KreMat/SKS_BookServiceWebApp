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
		em.createNamedQuery("Author.createAuthor", Author.class)
				.setParameter("firstname", author.getFirstname())
				.setParameter("lastname", author.getLastname())
				.setParameter("birthday", author.getBirthday());
	}

	public void updateAuthor(Author author) {
		em.createNamedQuery("Author.updateAuthor", Author.class)
				.setParameter("firstname", author.getFirstname())
				.setParameter("lastname", author.getLastname())
				.setParameter("birthday", author.getBirthday())
				.setParameter("id",author.getId());
	}

	public void deleteAuthor(long id) {
		em.createNamedQuery("Author.deleteAuthor", Author.class).setParameter("id", id);
	}

}
