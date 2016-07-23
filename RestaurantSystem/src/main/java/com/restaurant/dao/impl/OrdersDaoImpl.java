package com.restaurant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.dao.OrdersDao;
import com.restaurant.entity.Orders;

public class OrdersDaoImpl implements OrdersDao{

	private static final Logger logger = LogManager.getLogger(OrdersDaoImpl.class);
	
	private static final String SQL_CREATE_ORDER = "insert into Orders(dateTime , userId , status ) "
													+ "values(?, ? ,? )";
	private static final String SQL_GET_ALL = "Select * From Orders o WHERE o.status IS NULL OR o.status = '' ";
	private static final String SQL_SET_AS_DONE = "Update Orders o SET status = 'done' Where o.id = ?";
	private static final String SQL_GET_BY_ID = "Select * From Orders o WHERE o.id = ? ";
	private static final String SQL_GET_DONE_ORDERS = "Select * From Orders o Where o.status = 'done' AND o.userId = ?";
	private static final String SQL_SET_AS_PAID = "Update Orders o SET status = 'paid' Where o.id = ?";
	
	
	@Override
	public Orders createOrder(Connection connection ,Orders order) throws SQLException {
		
		try(PreparedStatement statement = connection.prepareStatement(SQL_CREATE_ORDER, Statement.RETURN_GENERATED_KEYS)) {	
			
			statement.setTimestamp(1, order.getDateTime());
			statement.setInt(2, order.getUserId());
			statement.setString(3, order.getStatus());			
			
			if(statement.executeUpdate() == 0) {
				throw new SQLException("Creating order failed , no rows affected!");
			}
			
			ResultSet generatedKey = statement.getGeneratedKeys();
			while(generatedKey.next()) {
				order.setId(generatedKey.getInt(1));
			}
			
		} catch(SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return order;
	}

	@Override
	public List<Orders> getOrdersList(Connection connection) throws SQLException {
		List<Orders> orderList = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL)) {	
			ResultSet set =	statement.executeQuery();
			
			while(set.next()) {
				Orders order = new Orders();
				order.setId(set.getInt("id"));
				order.setDateTime(set.getTimestamp("dateTime"));
				order.setUserId(set.getInt("userId"));
				order.setStatus(set.getString("status"));
				orderList.add(order);
			}
		} catch(SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return orderList;
	}

	@Override
	public void setStatusAsDone(Connection connection ,int orderId) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(SQL_SET_AS_DONE)) {
			statement.setInt(1, orderId);
			statement.executeUpdate();
			
		} catch(SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		
	}

	@Override
	public Orders findById(Connection connection ,int id) throws SQLException {
		Orders order = null;
		
		try(PreparedStatement statement = connection.prepareStatement(SQL_GET_BY_ID);) {
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				order = new Orders();
				order.setId(set.getInt("id"));
				order.setDateTime(set.getTimestamp("dateTime"));
				order.setUserId(set.getInt("userId"));
				order.setStatus(set.getString("status"));
			}
			
		} catch(SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return order;
	}

	@Override
	public void setStatusAsPaid(Connection connection, int orderId) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(SQL_SET_AS_PAID)) {
			statement.setInt(1, orderId);
			statement.executeUpdate();
			
		} catch(SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
	}

	@Override
	public List<Orders> getDoneOrdersList(Connection connection, int userId) throws SQLException {
		List<Orders> orderList = new ArrayList<>();

		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_DONE_ORDERS)) {
			statement.setInt(1, userId);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				Orders order = new Orders();
				order.setId(set.getInt("id"));
				order.setDateTime(set.getTimestamp("dateTime"));
				order.setUserId(set.getInt("userId"));
				order.setStatus(set.getString("status"));
				orderList.add(order);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}

		return orderList;
	}

}
