package com.restaurant.entity;

/**
 * This enumeration implement role types.
 * It contains two roles & for administrator and common user.
 * @author Tribel
 *
 */
public enum RoleEnum {

	ADMIN(1) , USER(2);
	
	private int value;
	
	private RoleEnum(int val) {
		this.value = val;
	}
	
	public int getValue() {return this.value; }
	
}
