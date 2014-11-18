/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.jboss.ejb3.annotation.SecurityDomain;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Publisher;

/**
 * @author Richard and Matthias
 *
 */
@Stateless(name = "publisherservice")
@LocalBean
@SecurityDomain("BookServiceWebAppSD")
@Transactional(rollbackOn = Exception.class)
public class PublisherService {

	@PersistenceContext
	private EntityManager em;
	
	@RolesAllowed("BSRead")
	public List<Publisher> getAllPublisher() {
		return em.createNamedQuery("Publisher.selectAll", Publisher.class)
				.getResultList();
	}

	@RolesAllowed("BSRead")
	public Publisher getPublisherById(long id) {
		return em.find(Publisher.class, id);
	}

	@RolesAllowed("BSWrite")
	public void createPublisher(Publisher publisher) {
		em.persist(publisher);
	}

	@RolesAllowed("BSWrite")
	public void updatePublisher(Publisher publisher) {
		em.merge(publisher);
	}

	@RolesAllowed("BSWrite")
	public void deletePublisher(long id) {
		em.remove(em.find(Publisher.class, id));
	}
}
