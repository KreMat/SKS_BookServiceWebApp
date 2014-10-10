/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Book;

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
}
