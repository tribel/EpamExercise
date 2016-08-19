package com.restaurant.web.beans;

import java.sql.Timestamp;
import java.util.List;

import com.restaurant.entity.Menu;
import com.restaurant.entity.Users;

/**
 * Class bean for administrator report 
 * @author Tribel
 *
 */
public class AdminBean {
	
	private int orderId;
	private java.sql.Timestamp dateTime;
	private Users user;
	private double totalSum;
	private List<Menu> dishList;
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Constructs default instance.
	 */
	public AdminBean() {
	}
	
	/**
	 * Constructs the {@link AdminBean} instance, with special parameters. 
	 * @param id of particular order.
	 * @param dateTime - date and time of the creation order.
	 * @param user instance which create the order.
	 * @param totalSum value of total order price.
	 */
	public AdminBean(int orderId, Timestamp dateTime, Users user,
			double totalSum) {
		super();
		this.orderId = orderId;
		this.dateTime = dateTime;
		this.user = user;
		this.totalSum = totalSum;
	}
	
	/**
	 * Constructs the {@link AdminBean} instance, with special parameters.
	 * @param id of particular order.
	 * @param dateTime - date and time of the creation order.
	 * @param totalSum value of total order price.
	 */
	public AdminBean(int orderId, Timestamp dateTime, double totalSum) {
		super();
		this.orderId = orderId;
		this.dateTime = dateTime;
		this.totalSum = totalSum;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public java.sql.Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(java.sql.Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public double getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(double totalSum) {
		this.totalSum = totalSum;
	}

	public List<Menu> getDishList() {
		return dishList;
	}

	public void setDishList(List<Menu> dishList) {
		this.dishList = dishList;
	}
	
	public void addDish(Menu menu) {
		dishList.add(menu);
	}
	
	
}
