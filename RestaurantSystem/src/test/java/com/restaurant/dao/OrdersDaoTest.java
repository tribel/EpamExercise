package com.restaurant.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import com.restaurant.dao.MyConnection;
import com.restaurant.dao.impl.OrdersDaoImpl;
import com.restaurant.entity.Orders;

public class OrdersDaoTest {

	OrdersDao ordersDao = new OrdersDaoImpl();
	
	@Test
	@Ignore
	public void testCreateOrder() throws IOException, SQLException {
		Connection connection = MyConnection.getConnection();
		connection.setAutoCommit(false);
		try {
			Orders orders = new Orders(Timestamp.valueOf(LocalDateTime.now()), 3);
			Orders tmpOrder = ordersDao.createOrder(null , orders);
			Assert.assertTrue(ordersDao.getOrdersList(null).contains(orders));
			Assert.assertFalse(tmpOrder.getId() == 0);
			System.out.println(tmpOrder.getId());
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			connection.rollback();
			connection.close();
		}
	}

	@Test
	@Ignore
	public void testGetOrdersList() {
		try (Connection connection = MyConnection.getConnection()){
			System.out.println(ordersDao.getOrdersList(null));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	@Ignore
	public void testSetStatusAsDone() throws IOException, SQLException {
		Connection connection = MyConnection.getConnection();
		connection.setAutoCommit(false);
		try {
			ordersDao.setStatusAsDone(null , 4);
			Assert.assertTrue(ordersDao.findById(null ,4).getStatus().equals("done"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			connection.rollback();
			connection.close();
		}
	}
	
	
	@Test
	@Ignore
	public void testFindById() {
		try (Connection connection = MyConnection.getConnection()){
			System.out.println(ordersDao.findById(null ,4));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
