/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Matthias
 *
 */
@Entity
@Table(name = "tb_publisher")
public class Publisher extends AbstractEntity {

	private static final long serialVersionUID = -3415256689285892364L;

	@Column(name = "publishername")
	private String name;

	@Column(name = "postcode")
	private String postcode;

	@Column(name = "countrycode")
	private String countrycode;

	@OneToMany(mappedBy = "publisher")
	private List<Book> books;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode
	 *            the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the countrycode
	 */
	public String getCountrycode() {
		return countrycode;
	}

	/**
	 * @param countrycode
	 *            the countrycode to set
	 */
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param books
	 *            the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
