package at.wien.technikum.winterhalderkreuzriegler.sks.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import at.wien.technikum.winterhalderkreuzriegler.sks.enums.Language;

@Entity
@Table(name = "tb_book")
@NamedQueries({
		@NamedQuery(name = "Book.selectAll", query = "SELECT b FROM Book b"),
		@NamedQuery(name = "Book.selectByTitle", query = "SELECT b FROM Book b WHERE b.title LIKE :title") })
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book extends AbstractEntity {

	private static final long serialVersionUID = 5159413079703017063L;

	@Column(name = "isbn")
	@XmlAttribute(name = "isbn")
	private String isbn;

	@Column(name = "title")
	@XmlAttribute(name = "title")
	private String title;

	@Column(name = "subtitle")
	@XmlAttribute(name = "subtitle")
	private String subtitle;

	@Column(name = "description")
	@XmlAttribute(name = "description")
	private String description;

	@Column(name = "pages")
	@XmlAttribute(name = "pages")
	private long pages;

	@Enumerated(EnumType.STRING)
	@Column(name = "language")
	@XmlAttribute(name = "language")
	private Language language;

	/*
	 * MANY TO ONE
	 */

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_publisher_id", nullable = true)
	@XmlElement(name = "publisher")
	private Publisher publisher;

	/*
	 * MANY TO MANY
	 */

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_author_has_tb_book", joinColumns = { @JoinColumn(name = "tb_book_id", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "tb_author_id", nullable = false) })
	@XmlElementWrapper(name = "authors")
	@XmlElement(name = "author")
	private List<Author> authors = new ArrayList<Author>();

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn
	 *            the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * @param subtitle
	 *            the subtitle to set
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the pages
	 */
	public long getPages() {
		return pages;
	}

	/**
	 * @param pages
	 *            the pages to set
	 */
	public void setPages(long pages) {
		this.pages = pages;
	}

	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher
	 *            the publisher to set
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the authors
	 */
	public List<Author> getAuthors() {
		return authors;
	}

	/**
	 * @param authors
	 *            the authors to set
	 */
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}
