/**
 * 
 */
package at.wien.technikum.winterhalderkreuzriegler.sks.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Richard und Matthias
 *
 */
@Entity
@Table(name = "tb_author")
public class Author extends AbstractEntity {

	private static final long serialVersionUID = 9035977779987405595L;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "birthday")
	private Date birthday;

	/*
	 * MANY TO MANY
	 */

	@ManyToMany
	@JoinTable(name = "tb_author_has_tb_book", joinColumns = { @JoinColumn(name = "tb_author_id", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "tb_book_id", nullable = false) })
	private List<Book> books;

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
