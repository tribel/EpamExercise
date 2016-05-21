package com.entity;

/**
 * 
 * @author Tribel
 *
 */
public abstract class Shape {
    public abstract double square();
    public abstract double perimeter();
    public abstract void move(double dx, double dy);

    @Override
    public String toString() {
        return " perimeter = " + perimeter() +" square = " +square();
    }
    
    @Override
    public Shape clone() {
    	try {
			return (Shape)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;				
		}
    }
}
