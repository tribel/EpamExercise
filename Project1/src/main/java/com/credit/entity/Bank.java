package com.credit.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Bank entity , consist credit list.
 * @author Tribel
 *
 */
public class Bank {

	private String bankName;
	private List<Credit> credit = new ArrayList<>();
	
	/**
	 * Default constructor.
	 */
	public Bank() {
	}
	
	/**
	 * 
	 * @param bankName {@link String} name of bank
	 * @param credit {@link List} of {@link Credit}
	 */
	public Bank(String bankName, List<Credit> credit) {
		this.bankName = bankName;
		for(Credit c: credit) {
			this.credit.add(c.clone());
		}
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public List<Credit> getCredit() {
		return credit;
	}

	public void setCredit(List<Credit> credit) {
		this.credit = credit;
	}


	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + "]";
	}
	
	
	
	
}
