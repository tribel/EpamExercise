package com.restaurant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.dao.OrderDishesDao;
import com.restaurant.entity.OrderDishes;

public class OrderDishesDaoImpl implements OrderDishesDao{
	
	private static final Logger logger = LogManager.getLogger(OrdersDaoImpl.class);
	
	private static final String SQL_FIND_BY_ID = "Select * From OrderDishes od Where od.orderId = ? ";
	private static final String SQL_TOTAL_PRICE = "Select SUM(price) AS sumprice From OrderDishes od Where od.orderId = ? ";
	private static final String SQL_INSERT_OD = "insert into OrderDishes(dishId, orderId ,price ) "
																			+ "values(?, ? ,? )";
	
	@Override
	public List<OrderDishes> findByOrderId(Connection connection, int id) throws SQLException {
		List<OrderDishes> orderDishesList = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID)) {		
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				OrderDishes orderDishes = new OrderDishes();
				orderDishes = new OrderDishes();
				orderDishes.setId(set.getInt("id"));
				orderDishes.setDishId(set.getInt("dishId"));
				orderDishes.setOrderId(set.getInt("orderId"));
				orderDishes.setPrice(set.getDouble("price"));
				orderDishesList.add(orderDishes);
			}
			
		} catch(SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return orderDishesList;
	}

	@Override
	public double getTotalOrderPrice(Connection connection, int orderId) throws SQLException {
		Double result = null;
		try(PreparedStatement statement = connection.prepareStatement(SQL_TOTAL_PRICE);) {
			statement.setInt(1, orderId);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				result = set.getDouble("sumprice");
			}
			
		} catch(SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return result;
	}

	@Override
	public void add(Connection connection, OrderDishes od) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(SQL_INSERT_OD)) {
			statement.setInt(1, od.getDishId());
			statement.setInt(2, od.getOrderId());
			statement.setDouble(3, od.getPrice());
			statement.executeUpdate();
	
		} catch(SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	
}
