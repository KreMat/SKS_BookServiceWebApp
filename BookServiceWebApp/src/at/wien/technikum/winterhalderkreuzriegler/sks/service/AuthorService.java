/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Richard and Matthias
 *
 */
@Stateless(name = "authorservice")
@LocalBean
public class AuthorService {

	@PersistenceContext
	private EntityManager em;

}
