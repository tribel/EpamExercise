package com.model.vehicle;

/**
 * Motorcycle class that extends from the vehicle , and describes the motorcycle behavior 
 * @author Tribel
 *
 */
public class Motorcycle extends Vehicle{

	protected String modelName;
	protected String enginePower;
	
	
	
	public Motorcycle() {
		super();
	}

	public Motorcycle(String modelName, String enginePower, String vehicleName, String serialNumber) {
		super(vehicleName, serialNumber);
		this.modelName = modelName;
		this.enginePower = enginePower;
	}

	public Motorcycle(String modelName, String enginePower) {
		super();
		this.modelName = modelName;
		this.enginePower = enginePower;
	}

	@Override
	public void doMove() {
		System.out.println("Motorcicle"+ modelName + "is moving now");
	}

}
