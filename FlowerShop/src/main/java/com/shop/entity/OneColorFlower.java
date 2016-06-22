package com.shop.entity;

import com.shop.flowerEnum.FlowerColor;


/**
 * Class that realized one color flower implementation.
 * Includes color type of the flower.
 * @author Tribel
 *
 */
public class OneColorFlower extends Flower {

	protected FlowerColor color;

	/**
	 * Constructor.
	 * @param color flower type color.
	 */
	public OneColorFlower(FlowerColor color) {
		super();
		this.color = color;
	}

	/**
	 * Default constructor.
	 */
	public OneColorFlower() {
		super();
	}

	public FlowerColor getColor() {
		return color;
	}

	public void setColor(FlowerColor color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "OneFlower [color=" + color + "]";
	}

}
