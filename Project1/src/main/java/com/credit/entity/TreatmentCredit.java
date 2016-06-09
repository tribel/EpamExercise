package com.credit.entity;

/**
 * Credit for treatment.
 * @author Tribel
 *
 */
public class TreatmentCredit extends Credit{
	
	protected String desease;
	
	/**
	 * Default constructor.
	 */
	public TreatmentCredit() {
		super();
	}

	/**
	 * 
	 * @param creditSerialNumber {@link String} identity serial number
	 * @param earlyLoanRepayment {@link Boolean} opportunity to early loan repayments
	 * @param creditLineUpper {@link Boolean} opportunity to up credit line
	 * @param value of credit
	 * @param desease {@link String} name of sickness
	 */
	public TreatmentCredit(String creditSerialNumber, boolean earlyLoanRepayment, 
						boolean creditLineUpper, double value, String desease) {
		
		super(creditSerialNumber, TypeCreditEnum.Treatment.toString(), 
				earlyLoanRepayment, creditLineUpper, value);
		this.desease = desease;
	}

	public String getDesease() {
		return desease;
	}

	public void setDesease(String desease) {
		this.desease = desease;
	}

	@Override
	public String toString() {
		return "TreatmentCredit [desease=" + desease + ", creditSerialNumber="
				+ creditSerialNumber + ", name=" + name
				+ ", earlyLoanRepayment=" + earlyLoanRepayment
				+ ", creditLineUpper=" + creditLineUpper + ", upperValue="
				+ upperValue + "]";
	}

	
	
}
