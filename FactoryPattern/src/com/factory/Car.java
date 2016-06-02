package com.factory;

/**
 * Abstract factory class 
 * @author Tribel
 *
 */
public abstract class Car {
	
	public Car(CarType model) {
        this.model = model;
        arrangeParts();
    }
 
    private void arrangeParts() {
    }
 
    protected abstract void construct();
 
    private CarType model = null;
 
    public CarType getModel() {
        return model;
    }
 
    public void setModel(CarType model) {
        this.model = model;
    }
}
