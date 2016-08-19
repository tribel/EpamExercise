package com.restaurant.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



import com.restaurant.entity.Menu;
import com.restaurant.entity.OrderDishes;

/**
 * Interface for treating, creating new for 
 * OrderDishes table in data base.
 * @author Tribel
 *
 */
public interface OrderDishesDao {
	
	/**
	 * Returning {@link OrderDishes} list entity in which have passed id. 
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param id of particular {@link OrderDishes} entity.
 	 * @return {@link OrderDishes} list that correspond passed id. 
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public List<OrderDishes> findByOrderId(Connection connection, int id) throws SQLException;

	/**
	 * Total  price of entire  order , that have passed id.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param orderId - id of particular order.
	 * @return sum of all the order.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public double getTotalOrderPrice(Connection connection, int orderId) throws SQLException;
	
	/**
	 * Adding new orderDish entity. 
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param od {@code OrderDish} entity that going to save.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public void add(Connection connection, OrderDishes od) throws SQLException; 
	
	
	public int getMenuListByOrderID(Connection connection,int id) throws SQLException;
	
}
