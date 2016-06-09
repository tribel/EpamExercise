package com.credit.entity;

/**
 * Enum for define all credits type. 
 * @author Tribel
 *
 */
public enum TypeCreditEnum {

	Treatment("Treatment") , Rest("Rest") , Education("Education") ;
	
	private String name;
	
	private TypeCreditEnum(String str) {
		name = str;
	}
	
	public String getString() {
		return name;
	}
}
