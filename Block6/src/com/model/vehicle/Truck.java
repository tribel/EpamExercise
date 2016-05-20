package com.model.vehicle;

/**
 * Truck is child of car class , thet describes big car - truck behavior
 * @author Tribel
 *
 */
public class Truck extends Car{

	protected String bodyVolume;
	
	public Truck() {
		super();
	}

	public Truck(String vehicleName, String serialNumber, String modelName,
			String enginePower, String maxSpeed, String bodyVolume) {
		
		super(vehicleName, serialNumber, modelName, enginePower, maxSpeed);
		this.bodyVolume = bodyVolume;
	}



	public Truck(String bodyVolume) {
		super();
		this.bodyVolume = bodyVolume;
	}



	@Override
	public void doMove() {
		System.out.println("Truck" + modelName + "is moving now");
	}
}
