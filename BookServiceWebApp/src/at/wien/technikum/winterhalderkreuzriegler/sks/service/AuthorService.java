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

import org.jboss.ejb3.annotation.SecurityDomain;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Author;

/**
 * @author Richard and Matthias
 *
 */
@Stateless(name = "authorservice")
@LocalBean
//@SecurityDomain("BookServiceWebAppSD")
//@RolesAllowed("BookUser")
public class AuthorService {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	SessionContext ctx;

	public List<Author> getAllAuthors() {
		return em.createNamedQuery("Author.selectAll", Author.class)
				.getResultList();
	}

	public Author getAuthorById(long id) {
		return em.find(Author.class, id);
	}

	public void createAuthor(Author author) {
		
		System.out.println("getCallerPricipal() => " + ctx.getCallerPrincipal());
		
		em.persist(author);
	}

	public void updateAuthor(Author author) {
		em.merge(author);
	}

	public void deleteAuthor(long id) {
		em.remove(em.find(Author.class,id));
	}

}
