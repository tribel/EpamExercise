package com.restaurant.web.beans;

import java.util.ArrayList;

import com.restaurant.entity.Menu;

/**
 * Class bean for realization menu cart
 * @author Tribel
 *
 */
public class CartBean {

	private ArrayList<Menu> allCartItems = new ArrayList<>();
	private double totalSum ;
	
	public int getCartItemCount() {
		return allCartItems.size();
	}

	public void addCartItem(Menu dish) {
		allCartItems.add(dish);
		totalSum += dish.getPrice();
	}
	
	public void deleteCartItem(Menu dish) {
		allCartItems.remove(dish);
		totalSum -= dish.getPrice();
	}
	
	public ArrayList<Menu> getAllCartItems() {
		return allCartItems;
	}

	public void setAllCartItems(ArrayList<Menu> allCartItems) {
		this.allCartItems = allCartItems;
	}

	public double getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(double totalSum) {
		this.totalSum = totalSum;
	}
	
	public void clearAllList() {
		this.allCartItems.clear();
		this.totalSum = 0.0;
	}
	
}
