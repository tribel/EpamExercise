package com.credit.entity;

/**
 * Credit for education
 * @author Tribel
 *
 */
public class EducationCredit extends Credit{

	protected float studyYears;

	public EducationCredit() {
		super();
	}

	/**
	 * 
	 * @param creditSerialNumber {@link String} identity serial number
	 * @param earlyLoanRepayment {@link Boolean} opportunity to early loan repayments
	 * @param creditLineUpper {@link Boolean} opportunity to up credit line
	 * @param value of credit
	 * @param studyYears {@link Float} duration of education
	 */
	public EducationCredit(String creditSerialNumber, boolean earlyLoanRepayment, 
			boolean creditLineUpper, double value, float studyYears) {

		super(creditSerialNumber, TypeCreditEnum.Education.toString(), 
				earlyLoanRepayment, creditLineUpper, value);
		this.studyYears = studyYears;
	}

	public float getStudyYears() {
		return studyYears;
	}

	public void setStudyYears(float studyYears) {
		this.studyYears = studyYears;
	}

	@Override
	public String toString() {
		return "EducationCredit [creditSerialNumber=" + creditSerialNumber
				+ ", earlyLoanRepayment=" + earlyLoanRepayment
				+ ", creditLineUpper=" + creditLineUpper + ", upperValue="
				+ upperValue +" university" + studyYears + "]";
	}
	
	@Override
	public EducationCredit clone() {
		return (EducationCredit)super.clone();
	}
}
