package main;

import java.time.LocalDate;

/**
 * Abstract class for product in the storage 
 * @author Tribel
 *
 */
public abstract class Product implements Cloneable{

	private String pruductName;
	private String manufacturer;
	private int count;
	private LocalDate dateOfManufacture;
	private LocalDate expirationDate; 
	private String provider;
	private String  providerTelephone;
	private String manufacturerTelephone;
	private double price;

	public Product() {
	}

	public Product(String pruductName, String manufacturer, int count,
					LocalDate dateOfManufacture, LocalDate expirationDate,
					String provider, String providerTelephone,
					String manufacturerTelephone, double price) {
			
		this.pruductName = pruductName;
		this.manufacturer = manufacturer;
		this.count = count;
		this.dateOfManufacture = dateOfManufacture;
		this.expirationDate = expirationDate;
		this.provider = provider;
		this.providerTelephone = providerTelephone;
		this.manufacturerTelephone = manufacturerTelephone;
		this.price = price;
	}

	public String getPruductName() {
		return pruductName;
	}

	public void setPruductName(String pruductName) {
		this.pruductName = pruductName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LocalDate getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(LocalDate dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProviderTelephone() {
		return providerTelephone;
	}

	public void setProviderTelephone(String providerTelephone) {
		this.providerTelephone = providerTelephone;
	}

	public String getManufacturerTelephone() {
		return manufacturerTelephone;
	}

	public void setManufacturerTelephone(String manufacturerTelephone) {
		this.manufacturerTelephone = manufacturerTelephone;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	/**
	 * Returns a hash code value for the object.
	 * @return  a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime
				* result
				+ ((dateOfManufacture == null) ? 0 : dateOfManufacture
						.hashCode());
		result = prime * result
				+ ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result
				+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime
				* result
				+ ((manufacturerTelephone == null) ? 0 : manufacturerTelephone
						.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((provider == null) ? 0 : provider.hashCode());
		result = prime
				* result
				+ ((providerTelephone == null) ? 0 : providerTelephone
						.hashCode());
		result = prime * result
				+ ((pruductName == null) ? 0 : pruductName.hashCode());
		return result;
	}

	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * @return  {@code true} if this object is the same as the obj.
     *          argument; {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (count != other.count)
			return false;
		if (dateOfManufacture == null) {
			if (other.dateOfManufacture != null)
				return false;
		} else if (!dateOfManufacture.equals(other.dateOfManufacture))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (manufacturerTelephone == null) {
			if (other.manufacturerTelephone != null)
				return false;
		} else if (!manufacturerTelephone.equals(other.manufacturerTelephone))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		if (providerTelephone == null) {
			if (other.providerTelephone != null)
				return false;
		} else if (!providerTelephone.equals(other.providerTelephone))
			return false;
		if (pruductName == null) {
			if (other.pruductName != null)
				return false;
		} else if (!pruductName.equals(other.pruductName))
			return false;
		return true;
	}

	
	/**
	 * @return  a string representation of the object.
	 */
	@Override
	public String toString() {
		return "Product [pruductName=" + pruductName + ", manufacturer="
				+ manufacturer + ", count=" + count + ", dateOfManufacture="
				+ dateOfManufacture + ", expirationDate=" + expirationDate
				+ ", provider=" + provider + ", providerTelephone="
				+ providerTelephone + ", manufacturerTelephone="
				+ manufacturerTelephone + ", price=" + price + "]";
	}
	
	
	 /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object.
     */
	@Override
	public Product clone() {
		try {
			return (Product)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
