package com.restaurant.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.restaurant.entity.OrderDishes;

public interface OrderDishesDao {
	
	/**
	 * 
	 * @param connection <code>Connection</code> 
	 * @param id <code>int</code> Order id 
 	 * @return <code>OrderDishes</code> list that corresponds to id of Order

	 * @throws SQLException
	 */
	public List<OrderDishes> findByOrderId(Connection connection, int id) throws SQLException;

	/**
	 * Total total price of entire each order
	 * @param connection
	 * @param orderId id of exact order
	 * @return {@code double}  
	 * @throws SQLException
	 */
	public double getTotalOrderPrice(Connection connection, int orderId) throws SQLException;
	
	/**
	 * Adding orderDish entity 
	 * @param connection
	 * @param od {@code OrderDish} entity
	 * @throws SQLException
	 */
	public void add(Connection connection, OrderDishes od) throws SQLException; 
	
	
}
