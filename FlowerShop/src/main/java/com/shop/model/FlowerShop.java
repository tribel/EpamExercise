package com.shop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.shop.entity.Flower;
import com.shop.flowerEnum.FreshType;


/**
 * Class that represents model part.
 * Include add flower to the shop, remove wilted flower.
 * Realized flower shop.
 * @author Tribel
 *
 */
public class FlowerShop {
	
	private List<Flower> flowers;
	
	/**
	 * Default constructor initialized 
	 * flowers list.
	 */
	public FlowerShop() {
		flowers = new ArrayList<>();
	}
	
	
	/**
	 * Adding flower to the shop list.
	 * @param flower {@link Flower} entity that will be added.
	 * @return flower list.
	 */
	public List<Flower> addFlowerToShop(Flower flower) {
		if(flower != null) flowers.add(flower);
		return this.flowers;	
	}
	
	/**
	 * @return flower list of the shop.
	 */
	public List<Flower> getFlowers() {
		return this.flowers;
	}
	
	
	/**
	 * Removing flowers that has Wilted type from
	 * shop flower list.
	 */
	public void removeWiltedFlowers() {
		Iterator<Flower> iterator = flowers.listIterator();
		while(iterator.hasNext()) {
			if(iterator.next().getFreshType() == FreshType.WILTED) {
				iterator.remove();
			}
		}
	}
	
}
