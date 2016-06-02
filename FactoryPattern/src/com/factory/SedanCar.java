package com.factory;


/**
 * Factory entity
 * @author Tribel
 *
 */
public class SedanCar extends Car{

	 SedanCar() {
	        super(CarType.SEDAN);
	        construct();
	    }
	 
	    @Override
	    protected void construct() {
	        System.out.println("Building sedan car");
	    }
}
