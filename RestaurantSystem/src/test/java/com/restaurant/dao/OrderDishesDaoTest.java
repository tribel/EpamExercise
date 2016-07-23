package com.restaurant.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import com.restaurant.dao.MyConnection;
import com.restaurant.dao.impl.OrderDishesDaoImpl;
import com.restaurant.entity.OrderDishes;


public class OrderDishesDaoTest {

	private OrderDishesDao orderDisshes = new OrderDishesDaoImpl();
	
	@Test
	@Ignore
	public void testFindById() {
		try (Connection connection = MyConnection.getConnection()){
			System.out.println(orderDisshes.findByOrderId(null , 1));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Ignore
	public void testGetTotalOrderPrice() {
		try (Connection connection = MyConnection.getConnection()){
			System.out.println(orderDisshes.getTotalOrderPrice(null ,1));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Ignore
	public void testAdd() throws IOException, SQLException {
		Connection connection = MyConnection.getConnection();
		connection.setAutoCommit(false);
		try {
			OrderDishes orDishes = new OrderDishes(1, 1, 30.0);
			orderDisshes.add(null , orDishes);
			System.out.println(orderDisshes.getTotalOrderPrice(null ,1));	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			connection.rollback();
			connection.close();
		}
	}

}
