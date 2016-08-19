package com.restaurant.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.restaurant.entity.Orders;

/**
 * Interface for treating, creating new for 
 * Order table in data base.
 * @author Tribel
 *
 */
public interface OrdersDao {

	/**
	 *  Creating new order , save the {@link Orders} instance to data base.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param order {@link Orders} object for creation. 
	 * @return already created order object with particular id.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public Orders createOrder(Connection connection ,Orders order) throws SQLException;
	
	/**
	 * Returning full list of orders that have 'done' status. 
	 * @param connection {@link Connection} (session) with a specific database.
	 * @return all order list that created by user and not to confirmed by administrator
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public List<Orders> getOrdersList(Connection connection) throws SQLException;
	
	
	public List<Orders> getHistory(Connection connection) throws SQLException;
	/**
	 * Set order status as 'done'.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param id  of particular order that will be marked as 'done'.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public void setStatusAsDone(Connection connection ,int orderId) throws SQLException;
	
	/**
	 * Find order by passed id.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param id of particular order.
	 * @return order that have exact id.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public Orders findById(Connection connection ,int id) throws SQLException;
		
	/**
	 *  Set order status as 'paid'.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param id of particular order that will be marked as 'paid'.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public void setStatusAsPaid(Connection connection, int orderId) throws SQLException;
	
	/**
	 * Set exact order as 'denial'.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param orderId {@link Integer} order id , that will be marked as 'denial'.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection. 
	 */
	public void setStatusAsDenial(Connection connection, int orderId) throws SQLException;
	
	/**
	 * Get all order list that marked as done
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param id of user for which returning done orders list.
	 * @return {@link List} of the orders that have 'done' status to particular user.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public List<Orders> getDoneOrdersList(Connection connection, int userId) throws SQLException;
	
}
