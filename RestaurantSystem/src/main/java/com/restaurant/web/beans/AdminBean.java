package com.restaurant.web.beans;

import java.sql.Timestamp;

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
	
	public AdminBean() {
	}
	
	public AdminBean(int orderId, Timestamp dateTime, Users user,
			double totalSum) {
		super();
		this.orderId = orderId;
		this.dateTime = dateTime;
		this.user = user;
		this.totalSum = totalSum;
	}
	
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
	
}
