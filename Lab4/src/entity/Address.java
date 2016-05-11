package entity;

/**
 * Address entity 
 * @author Tribel
 *
 */
public class Address {
	
	private String index;
	private String city;
	private String street;
	private String houseNumber;
	private String flatNumber;
	
	public Address(String index, String city, String street, String houseNumber, String flatNumber) {
		this.index = index;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.flatNumber = flatNumber;
	}

	public Address() {
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	@Override
	public String toString() {
		return "Address [index=" + index + ", city=" + city + ", street="
				+ street + ", houseNumber=" + houseNumber + ", flatNumber="
				+ flatNumber + "]";
	}
	
	
	
}
