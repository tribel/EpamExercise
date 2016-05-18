package main;

import java.time.LocalDate;

/**
 * Extended class that point to the customer information and products buy date
 * 
 * @author Tribel
 *
 */
public class ProductCustomer extends Product {

	private String customerName;
	private String customerTelephone;
	private LocalDate buyDate;

	public ProductCustomer() {
		super();
	}

	public ProductCustomer(String pruductName, String manufacturer, int count,
			LocalDate dateOfManufacture, LocalDate expirationDate,
			String provider, String providerTelephone,
			String manufacturerTelephone, double price) {

		super(pruductName, manufacturer, count, dateOfManufacture,
				expirationDate, provider, providerTelephone,
				manufacturerTelephone, price);
	}

	public ProductCustomer(String pruductName, String manufacturer, int count,
			LocalDate dateOfManufacture, LocalDate expirationDate,
			String provider, String providerTelephone,
			String manufacturerTelephone, double price, String customerName,
			String customerTelephone, LocalDate buyDate) {
		
		super(pruductName, manufacturer, count, dateOfManufacture,
				expirationDate, provider, providerTelephone,
				manufacturerTelephone, price);
		
		this.customerName = customerName;
		this.customerTelephone = customerTelephone;
		this.buyDate = buyDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerTelephone() {
		return customerTelephone;
	}

	public void setCustomerTelephone(String customerTelephone) {
		this.customerTelephone = customerTelephone;
	}

	public LocalDate getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(LocalDate buyDate) {
		this.buyDate = buyDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((buyDate == null) ? 0 : buyDate.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime
				* result
				+ ((customerTelephone == null) ? 0 : customerTelephone
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCustomer other = (ProductCustomer) obj;
		if (buyDate == null) {
			if (other.buyDate != null)
				return false;
		} else if (!buyDate.equals(other.buyDate))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerTelephone == null) {
			if (other.customerTelephone != null)
				return false;
		} else if (!customerTelephone.equals(other.customerTelephone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductCustomer [customerName=" + customerName
				+ ", customerTelephone=" + customerTelephone + ", buyDate="
				+ buyDate + "]";
	}
	
	@Override
	public ProductCustomer clone() {
		return (ProductCustomer)super.clone();
	}

}
