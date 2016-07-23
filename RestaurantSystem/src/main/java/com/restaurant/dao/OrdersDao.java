package com.restaurant.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.restaurant.entity.Orders;

public interface OrdersDao {

	/**
	 * 
	 * @param connection sql {@code Connection}
	 * @param order Order object for creation 
	 * @return already created order object with id.
	 * @throws SQLException
	 */
	public Orders createOrder(Connection connection ,Orders order) throws SQLException;
	
	/**
	 * 
	 * @param connection sql {@code Connection}
	 * @return all order list that created by user and not to confirmed by administrator
	 * @throws SQLException
	 */
	public List<Orders> getOrdersList(Connection connection) throws SQLException;
	
	/**
	 * Set order status as done
	 * @param connection sql {@code Connection}
	 * @param orderId {@code int} order id , that will be marked as done
	 * @throws SQLException
	 */
	public void setStatusAsDone(Connection connection ,int orderId) throws SQLException;
	
	/**
	 * Find order by id
	 * @param connection sql {@code Connection}
	 * @param id {@code int} 
	 * @return order that have exact id
	 * @throws SQLException
	 */
	public Orders findById(Connection connection ,int id) throws SQLException;
		
	/**
	 *  Set order status as paid
	 * @param connection sql {@code Connection}
	 * @param orderId {@code int} order id , that will be marked as paid
	 * @throws SQLException
	 */
	public void setStatusAsPaid(Connection connection, int orderId) throws SQLException;
	
	/**
	 * Get all order list that marked as done
	 * @param connection
	 * @param userId {@code int} user id.
	 * @return orders list
	 * @throws SQLException
	 */
	public List<Orders> getDoneOrdersList(Connection connection, int userId) throws SQLException;
	
}
