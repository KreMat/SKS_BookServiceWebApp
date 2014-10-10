package at.wien.technikum.winterhalderkreuzriegler.sks.webservice.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import at.wien.technikum.winterhalderkreuzriegler.sks.enums.Language;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BookDto {

	private long id;

	private String isbn;

	private String title;

	private String subtitle;

	private String description;

	private long pages;

	private Language language;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookDto [id=" + id + ", isbn=" + isbn + ", title=" + title
				+ ", subtitle=" + subtitle + ", description=" + description
				+ ", pages=" + pages + ", language=" + language + "]";
	}

}
