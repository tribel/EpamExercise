package com.shop.entity;

import com.shop.flowerEnum.FlowerColor;

/**
 * Class that implements flower wrapper.
 * includes flower color. Accessory type class.
 * @author Tribel
 *
 */
public class FlowerWrapper extends Accessory {

	protected FlowerColor wrapperColor;

	/**
	 * Default constructor.
	 */
	public FlowerWrapper() {
		super();
	}

	/**
	 * Constructor.
	 * @param wrapperColor color type of the wrapper.
	 */
	public FlowerWrapper(FlowerColor wrapperColor) {
		super();
		this.wrapperColor = wrapperColor;
	}

	public FlowerColor getWrapperColor() {
		return wrapperColor;
	}

	public void setWrapperColor(FlowerColor wrapperColor) {
		this.wrapperColor = wrapperColor;
	}

	@Override
	public String toString() {
		return "FlowerWrapper [wrapperColor=" + wrapperColor + "]";
	}

}
