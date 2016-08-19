package com.restaurant.exception;

/**
 * Custom exception for incorrect bind abstract factory realization
 * @author Tribel
 *
 */
public class IncorrectIOCRealize extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public IncorrectIOCRealize() {
		super();
	}
	
	@Override
	public String getMessage() {
		return "Incorrect realization of interface";	
	}
}
