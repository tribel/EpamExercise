package com.credit.entity;


/**
 * Credit entity, consist serial number, name and credit properties.
 * @author Tribel
 *
 */
public class Credit implements Cloneable{

	protected String creditSerialNumber;
	protected String name;
	protected boolean earlyLoanRepayment;
	protected boolean creditLineUpper;
	protected double upperValue;
	
	
	/**
	 * Default constructor.
	 */
	public Credit() {
	}

	/**
	 * 
	 * @param creditSerialNumber {@link String} identity serial number
	 * @param name {@link String} goal of credit
	 * @param earlyLoanRepayment {@link Boolean} opportunity to early loan repayments
	 * @param creditLineUpper {@link Boolean} opportunity to up credit line
	 * @param value of credit
	 */
	public Credit(String creditSerialNumber, String name ,boolean earlyLoanRepayment,
			boolean creditLineUpper, double value) {
	
		this.name = name;
		this.creditSerialNumber = creditSerialNumber;
		this.earlyLoanRepayment = earlyLoanRepayment;
		this.creditLineUpper = creditLineUpper;
		this.upperValue = value;
	}

	public String getCreditSerialNumber() {
		return creditSerialNumber;
	}

	public void setCreditSerialNumber(String creditSerialNumber) {
		this.creditSerialNumber = creditSerialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEarlyLoanRepayment() {
		return earlyLoanRepayment;
	}

	public void setEarlyLoanRepayment(boolean earlyLoanRepayment) {
		this.earlyLoanRepayment = earlyLoanRepayment;
	}

	public boolean isCreditLineUpper() {
		return creditLineUpper;
	}

	public void setCreditLineUpper(boolean creditLineUpper) {
		this.creditLineUpper = creditLineUpper;
	}

	public double getValue() {
		return upperValue;
	}

	public void setValue(double value) {
		this.upperValue = value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((creditSerialNumber == null) ? 0 : creditSerialNumber
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credit other = (Credit) obj;
		if (creditSerialNumber == null) {
			if (other.creditSerialNumber != null)
				return false;
		} else if (!creditSerialNumber.equals(other.creditSerialNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Credit [creditSerialNumber=" + creditSerialNumber + ", name="
				+ name + ", earlyLoanRepayment=" + earlyLoanRepayment
				+ ", creditLineUpper=" + creditLineUpper + ", upperValue="
				+ upperValue + "]";
	}

	@Override
	public Credit clone() {
		try {
			return (Credit)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
