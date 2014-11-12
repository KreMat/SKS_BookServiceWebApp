/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Richard und Matthias
 *
 */
@Entity
@Table(name = "tb_author")
@NamedQueries({
	@NamedQuery(name = "Author.selectAll", query = "SELECT a FROM Author a"),
	@NamedQuery(name = "Author.selectByFirstAndLastname", query = "SELECT a FROM Author a WHERE a.firstname LIKE :firstname AND a.lastname LIKE :lastname"),
	@NamedQuery(name = "Author.selectByLastname", query = "SELECT a FROM Author a WHERE a.lastname LIKE :lastname")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Author extends AbstractEntity {

	private static final long serialVersionUID = 9035977779987405595L;

	@Column(name = "firstname")
	@XmlAttribute(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	@XmlAttribute(name = "lastname")
	private String lastname;

	@Column(name = "birthday")
	@XmlAttribute(name = "birthday")
	private Date birthday;

	/*
	 * MANY TO MANY
	 */

	@ManyToMany
	@JoinTable(name = "tb_author_has_tb_book", joinColumns = { @JoinColumn(name = "tb_author_id", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "tb_book_id", nullable = false) })
	@XmlTransient
	private List<Book> books = new ArrayList<Book>();

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
