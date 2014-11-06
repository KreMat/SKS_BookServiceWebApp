/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Richard and Matthias
 *
 */
@Entity
@Table(name = "tb_publisher")
@XmlRootElement(name = "publisher")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = "Publisher.selectByName", query = "SELECT p FROM Publisher p WHERE p.name LIKE :name"),
	@NamedQuery(name = "Publisher.selectAll", query = "SELECT p FROM Publisher p")
})
public class Publisher extends AbstractEntity {

	private static final long serialVersionUID = -3415256689285892364L;

	@Column(name = "publishername")
	@XmlAttribute(name = "name")
	private String name;

	@Column(name = "postcode")
	@XmlAttribute(name = "postcode")
	private String postcode;

	@Column(name = "countrycode")
	@XmlAttribute(name = "countrycode")
	private String countrycode;

	@OneToMany(mappedBy = "publisher")
	@XmlTransient
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
