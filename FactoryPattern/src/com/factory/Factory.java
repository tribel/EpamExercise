package com.factory;

/**
 * Factory pattern
 * @author Tribel
 *
 */
public class Factory {
	
	 public static Car buildCar(CarType model) {
	        Car car = null;
	        switch (model) {
	        case SMALL:
	            car = new SmallCar();
	            break;
	 
	        case SEDAN:
	            car = new SedanCar();
	            break;
	 
	        case LUXURY:
	            car = new LuxuryCar();
	            break;
	 
	        default:
	            // throw some exception
	            break;
	        }
	        return car;
	    }
}
