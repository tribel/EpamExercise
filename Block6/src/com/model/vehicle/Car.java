package com.model.vehicle;

/**
 * Car class that extends from vehicle and describes car behavior 
 * @author Tribel
 *
 */
public class Car extends Vehicle {

	protected String modelName;
	protected String enginePower;
	protected String maxSpeed;
	
	public Car() {
		super();
	}

	public Car(String vehicleName, String serialNumber, String modelName, String enginePower, String maxSpeed) {
		super(vehicleName, serialNumber);
		this.modelName = modelName;
		this.enginePower = enginePower;
		this.maxSpeed = maxSpeed;
	}


	public Car(String modelName, String enginePower, String maxSpeed) {
		super();
		this.modelName = modelName;
		this.enginePower = enginePower;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public void doMove() {
		System.out.println("Car" + modelName + "is moving now");
	}

}
