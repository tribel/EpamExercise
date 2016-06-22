package com.shop.entity;

import com.shop.flowerEnum.BasketSize;

/**
 * Accessory. Basket class of size and 
 * capacity of the basket.
 * @author Tribel
 *
 */
public class Basket {

	protected BasketSize basketSize;
	protected int capacity;

	/**
	 * Default constructor.	
	 */
	public Basket() {
	}
	
	public BasketSize getBasketSize() {
		return basketSize;
	}

	public void setBasketSize(BasketSize basketSize) {
		this.basketSize = basketSize;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Basket [basketSize=" + basketSize + ", capacity=" + capacity
				+ "]";
	}

}
