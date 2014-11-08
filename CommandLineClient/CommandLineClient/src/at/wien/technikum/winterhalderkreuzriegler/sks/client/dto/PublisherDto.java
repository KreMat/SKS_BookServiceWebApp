package at.wien.technikum.winterhalderkreuzriegler.sks.client.dto;


public class PublisherDto {
	
	private String name;

	private String postcode;

	public PublisherDto(String name, String postcode, String countrycode) {
		super();
		this.name = name;
		this.postcode = postcode;
		this.countrycode = countrycode;
	}

	private String countrycode;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
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
	 * @param postcode the postcode to set
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
	 * @param countrycode the countrycode to set
	 */
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

}
