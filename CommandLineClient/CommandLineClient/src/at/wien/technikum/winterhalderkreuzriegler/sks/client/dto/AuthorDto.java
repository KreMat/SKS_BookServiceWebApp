package at.wien.technikum.winterhalderkreuzriegler.sks.client.dto;


public class AuthorDto{
	
	private String firstname;
	
	private String lastname;
	
	private String birthday;

	public AuthorDto(String firstname, String lastname, String birthday) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
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
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}