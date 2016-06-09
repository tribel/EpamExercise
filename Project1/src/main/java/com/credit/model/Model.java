package com.credit.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;



import com.credit.entity.Bank;
import com.credit.entity.Credit;
import com.credit.entity.EducationCredit;
import com.credit.entity.RestCredit;
import com.credit.entity.TreatmentCredit;

/**
 * Initialize bank data , store bank list and filters data.
 * @author Tribel
 *
 */
public class Model {

	private List<Bank> bankList;
	
	/**
	 * Default constructor , initialize bankList.
	 */
	public Model() {
		bankList = new ArrayList<>();
		bankDataInitialize();
	}
	
	/**
	 * Initialize bank list.
	 */
	protected void bankDataInitialize() {
		List<Credit> tmpCreditList = new LinkedList<>();
			tmpCreditList.add(new EducationCredit("AlphaBankCredit#1", true, true, 1000.0, 4));
			tmpCreditList.add(new RestCredit("AlphaBankCredit#2", false, true, 3000.0, 10));
			tmpCreditList.add(new TreatmentCredit("AlphaBankCredit#3", true, false, 500.0, "hemorrhoids"));
		bankList.add(new Bank("Alpha Bank", tmpCreditList));
		tmpCreditList.clear();

		tmpCreditList.add(new EducationCredit("PrivatBankCredit#1", false, false, 1500.0, 6.0f));
		tmpCreditList.add(new EducationCredit("PrivatBankCredit#2", true, true, 1500.0, 5.5f));
		tmpCreditList.add(new RestCredit("PrivatBankCredit#3", true, true, 30000.0, 5));
		bankList.add(new Bank("Privat Bank", tmpCreditList));
	}  

	/**
	 * @return {@link Bank} {@link List} that exist now.
	 */
	public List<Bank> getBankList() {
		return bankList;
	}
	
	
	/**
	 * @return all {@link Credit} in all existing banks.
	 */
	public List<Credit> getAllCreditList() {
		List<Credit> finalList = new ArrayList<>();
		for(Bank b: bankList) {
			finalList.addAll(b.getCredit());
		}
		
		return finalList;
	}
	
	/**
	 * Filter for finding exact {@link Credit}
	 * @param goal {@link String} of needed credit
	 * @param earlyRep {@link Boolean} 
	 * @param lineUp {@link Boolean}
	 * @return {@link Credit} {@link List} of filtered data.
	 */
	public List<Credit> findCreditByFilter(String goal, boolean earlyRep, boolean lineUp) {
		List<Credit> list = getAllCreditList();
		list =  list.stream().filter(x -> x.getName().equals(goal))
							 .filter(x -> x.isEarlyLoanRepayment() == earlyRep)
					       	 .filter(x -> x.isCreditLineUpper() == lineUp).collect(Collectors.toList());
		return list; 
	}

}
