package com.shop.entity;

import java.util.List;

import com.shop.flowerEnum.FlowerColor;

/**
 * Class that implements flower that has 
 * multicolor type. Includes list of colors.
 * @author Tribel
 *
 */
public class MultiColorFlower {

	protected List<FlowerColor> colors;

	/**
	 * Default constructor.
	 */
	public MultiColorFlower() {
		super();
	}

	/**
	 * Constructor.
	 * @param colors color type of the flower.
	 */
	public MultiColorFlower(List<FlowerColor> colors) {
		super();
		this.colors = colors;
	}

	public List<FlowerColor> getColors() {
		return colors;
	}

	public void setColors(List<FlowerColor> colors) {
		this.colors = colors;
	}

	@Override
	public String toString() {
		return "MultiColorFlower [colors=" + colors + "]";
	}

}
