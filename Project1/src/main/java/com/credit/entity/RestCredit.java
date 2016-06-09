package com.credit.entity;

/**
 * Credit for rest.
 * @author Tribel
 *
 */
public class RestCredit extends Credit{
	
	protected int daysDuration;

	/**
	 * Default constructor.
	 */
	public RestCredit() {
		super();
	}

	/**
	 * 
	 * @param creditSerialNumber {@link String} identity serial number
	 * @param earlyLoanRepayment {@link Boolean} opportunity to early loan repayments
	 * @param creditLineUpper {@link Boolean} opportunity to up credit line
	 * @param value of credit
	 * @param duration {@link Integer} on rest
	 */
	public RestCredit(String creditSerialNumber, boolean earlyLoanRepayment,
			boolean creditLineUpper, double value, int duration) {
		
		super(creditSerialNumber, TypeCreditEnum.Rest.toString(), 
				earlyLoanRepayment, creditLineUpper, value);
		this.daysDuration = duration;
	}

	public int getDaysDuration() {
		return daysDuration;
	}

	public void setDaysDuration(int daysDuration) {
		this.daysDuration = daysDuration;
	}

	@Override
	public String toString() {
		return "RestCredit [daysDuration=" + daysDuration
				+ ", creditSerialNumber=" + creditSerialNumber + ", name="
				+ name + ", earlyLoanRepayment=" + earlyLoanRepayment
				+ ", creditLineUpper=" + creditLineUpper + ", upperValue="
				+ upperValue + "]";
	}

	@Override
	public RestCredit clone() {
		return (RestCredit)super.clone();
	}
	
}
