package com.restaurant.entity;

public enum RoleEnum {

	ADMIN(1) , USER(2);
	
	private int value;
	
	private RoleEnum(int val) {
		this.value = val;
	}
	
	public int getValue() {return this.value; }
	
}
