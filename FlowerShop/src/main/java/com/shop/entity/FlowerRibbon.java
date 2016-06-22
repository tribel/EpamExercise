package com.shop.entity;


/**
 * Class that implements flower ribbon implementation.
 * includes length of the ribbon.
 * @author Tribel
 *
 */
public class FlowerRibbon extends Accessory {

	private int length;

	/**
	 * Default constructor. 
	 */
	public FlowerRibbon() {
		super();
	}
	/**
	 * Constructor
	 * @param length of the ribbon.
	 */
	public FlowerRibbon(int length) {
		super();
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "FlowerRibbon [length=" + length + "]";
	}

}
