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
@Stateless(name = "publisherservice")
@LocalBean
public class PublisherService {

	@PersistenceContext
	private EntityManager em;
}
