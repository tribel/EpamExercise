package com.restaurant.entity;

/**
 *  Entity for union dishId and orderId
 * @author Tribel
 *
 */
public class OrderDishes {

	private int id;
	private int dishId;
	private int orderId;
	private double price;

	public OrderDishes() {
	}

	public OrderDishes(int dishId, int orderId, double price) {
		super();
		this.dishId = dishId;
		this.orderId = orderId;
		this.price = price;
	}

	public OrderDishes(int dishId, double price) {
		super();
		this.dishId = dishId;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dishId;
		result = prime * result + id;
		result = prime * result + orderId;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDishes other = (OrderDishes) obj;
		if (dishId != other.dishId)
			return false;
	
		if (orderId != other.orderId)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDishes [id=" + id + ", dishId=" + dishId + ", orderId="
				+ orderId + ", price=" + price + "]";
	}

}
