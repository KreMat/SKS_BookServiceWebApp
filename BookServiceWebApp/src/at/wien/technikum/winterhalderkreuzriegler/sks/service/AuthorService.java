/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.service;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.jboss.ejb3.annotation.SecurityDomain;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Author;

/**
 * @author Richard and Matthias
 *
 */
@Stateless(name = "authorservice")
@LocalBean
@SecurityDomain("BookServiceWebAppSD")
@Transactional(rollbackOn = Exception.class)
public class AuthorService {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	SessionContext ctx;

	@RolesAllowed("BSRead")
	public List<Author> getAllAuthors() {
		return em.createNamedQuery("Author.selectAll", Author.class)
				.getResultList();
	}

	@RolesAllowed("BSRead")
	public Author getAuthorById(long id) {
		return em.find(Author.class, id);
	}

	@RolesAllowed("BSWrite")
	public void createAuthor(Author author) {
		em.persist(author);
	}

	@RolesAllowed("BSWrite")
	public void updateAuthor(Author author) {
		em.merge(author);
	}

	@RolesAllowed("BSWrite")
	public void deleteAuthor(long id) {
		em.remove(em.find(Author.class,id));
	}

}
