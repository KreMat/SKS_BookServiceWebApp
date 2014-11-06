/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import at.wien.technikum.winterhalderkreuzriegler.sks.entity.Publisher;

/**
 * @author Richard and Matthias
 *
 */
@Stateless(name = "publisherservice")
@LocalBean
public class PublisherService {

	@PersistenceContext
	private EntityManager em;
	
	public List<Publisher> getAllPublisher() {
		return em.createNamedQuery("Publisher.selectAll", Publisher.class)
				.getResultList();
	}

	public Publisher getPublisherById(long id) {
		return em.find(Publisher.class, id);
	}

	public void createPublisher(Publisher publisher) {
		em.persist(publisher);
	}

	public void updatePublisher(Publisher publisher) {
		em.merge(publisher);
	}

	public void deletePublisher(long id) {
		em.remove(id);
	}
}
