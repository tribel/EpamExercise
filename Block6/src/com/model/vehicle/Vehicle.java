package com.model.vehicle;

/**
 * Abstract class for global vehicle that define any transport stuff 
 * @author Tribel
 *
 */
public abstract class Vehicle {

	protected String vehicleName;
	protected String serialNumber;
	
	public Vehicle() {
	}
	
	
	public Vehicle(String vehicleName, String serialNumber) {
		super();
		this.vehicleName = vehicleName;
		this.serialNumber = serialNumber;
	}
	
	/**
	 * Method that define entity move 
	 */
	public abstract void doMove();
	
}
