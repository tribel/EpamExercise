package com.restaurant.service;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.restaurant.dao.OrderDishesDao;
import com.restaurant.entity.OrderDishes;
import com.restaurant.service.impl.OrderDishesServiceImpl;

public class OrderDishesServiceImplTest {

	OrderDishesDao orderDishesDao = new OrderDishesDao() {
		
		List<OrderDishes> list = new ArrayList<>();
		
		@Override
		public double getTotalOrderPrice(Connection connection, int orderId)
				throws SQLException {
			
			return list.stream().filter(x -> x.getOrderId() == orderId)
								.mapToDouble(OrderDishes::getPrice)
								.sum();
		}
		
		@Override
		public List<OrderDishes> findByOrderId(Connection connection, int id)
				throws SQLException {

			return list.stream().filter(x -> x.getOrderId() == id)
								.collect(Collectors.toList());
		}
		
		@Override
		public void add(Connection connection, OrderDishes od) throws SQLException {
			if(od != null) list.add(od);
		}

		@Override
		public int getMenuListByOrderID(Connection connection, int id)
				throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	
	private OrderDishesService odService = new OrderDishesServiceImpl(orderDishesDao, new TransactionWrapperTest());
	
	@Before
	public void init() throws SQLException {
		orderDishesDao.add(null, new OrderDishes(2, 4, 12.0));
		orderDishesDao.add(null, new OrderDishes(3, 4, 15.0));
		orderDishesDao.add(null, new OrderDishes(1, 10, 20.5));
		orderDishesDao.add(null, new OrderDishes(4, 15, 33.0));
	}
	
	@Test
	public void testFindByOrderId() {
		List<OrderDishes> list = new ArrayList<>();
		list.add(new OrderDishes(2, 4, 12.0));
		list.add(new OrderDishes(3, 4, 15.0));
		
		assertTrue(odService.findByOrderId(4).equals(list));
		
	}

	@Test
	public void testGetTotalOrderPrice() {
		assertEquals(odService.getTotalOrderPrice(4), 27.00, 0.01);
	}

}
