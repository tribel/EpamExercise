package com.shop.entity;


/**
 * Abstract class for accessory and 
 * cost of it.
 * @author Tribel
 *
 */
public abstract class Accessory {

	protected int cost;

	/**
	 * Default constructor
	 */
	public Accessory() {
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Accessory [cost=" + cost + "]";
	}
	
	
}
