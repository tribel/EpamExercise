package com.restaurant.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *  This class implements order  representation. 
 *  It contains id, date-time , users id and status.
 * @author Tribel
 *
 */
public class Orders {

	private int id;
	private java.sql.Timestamp dateTime;
	private int userId;
	private String status;

	/**
	 *  Constructs default instance.
	 *  Set date-time value by current time. 
	 */
	public Orders() {
		this.dateTime = Timestamp.valueOf(LocalDateTime.now());
	}

	/**
	 * Constructs {@link Orders} instance.
	 * @param date and time {@link Timestamp} of creating order.
	 * @param id of the user.
	 * @param order {@link String} status.
	 */
	public Orders(Timestamp dateTime, int userId, String status) {
		super();
		this.dateTime = dateTime;
		this.userId = userId;
		this.status = status;
	}
	
	/**
	 * Constructs {@link Orders} instance.
	 *	@param date and time {@link Timestamp} of creating order.
	 *  @param id of the user.
	 */
	public Orders(Timestamp dateTime, int userId) {
		super();
		this.dateTime = dateTime;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.sql.Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(java.sql.Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + userId;
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
		Orders other = (Orders) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
	
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", dateTime=" + dateTime + ", userId="
				+ userId + ", status=" + status + "]";
	}

}
