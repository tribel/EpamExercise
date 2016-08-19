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
import com.restaurant.dao.OrdersDao;
import com.restaurant.dao.UsersDao;
import com.restaurant.entity.OrderDishes;
import com.restaurant.entity.Orders;
import com.restaurant.entity.Users;
import com.restaurant.service.impl.OrdersServiceImpl;

public class OrdersServiceImplTest {

	OrderDishesDao orderDishesDao = new OrderDishesServiceImplTest().orderDishesDao;
	UsersDao usersDao = new UsersServiceImplTest().usersDao;
	
	OrdersDao ordersDao = new OrdersDao() {
		
		List<Orders> list = new ArrayList<>();
 		
		@Override
		public void setStatusAsPaid(Connection connection, int orderId)
				throws SQLException {
			
			for(Orders o: list) {
				if(o.getId() == orderId) {
					o.setStatus("paid");
					break;
				}
			}
		}
		
		@Override
		public void setStatusAsDone(Connection connection, int orderId)
				throws SQLException {
			
			for(Orders o: list) {
				if(o.getId() == orderId) {
					o.setStatus("done");
					break;
				}
			}
		}
		
		@Override
		public void setStatusAsDenial(Connection connection, int orderId)
				throws SQLException {
			
			for(Orders o: list) {
				if(o.getId() == orderId) {
					o.setStatus("denial");
					break;
				}
			}
		}
		
		@Override
		public List<Orders> getOrdersList(Connection connection)
				throws SQLException {

			return list;
		}
		
		@Override
		public List<Orders> getDoneOrdersList(Connection connection, int userId)
				throws SQLException {
			
			return list.stream().filter(x -> x.getStatus().equals("done"))
								.collect(Collectors.toList());
		}
		
		@Override
		public Orders findById(Connection connection, int id) throws SQLException {
			return list.stream().filter(x -> x.getId() == id)
								.findFirst()
								.get();
		}
		
		@Override
		public Orders createOrder(Connection connection, Orders order)
				throws SQLException {
			order.setId(list.size() + 1);
			list.add(order);
			return order;
		}

		@Override
		public List<Orders> getHistory(Connection connection)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	private OrdersService orderService = new OrdersServiceImpl(ordersDao, orderDishesDao, 
																usersDao, new TransactionWrapperTest());
	@Before
	@Test
	public void testCreateOrder() {
		Users tmpUser = new Users("test", "test");
		List<OrderDishes> orderDishesList = new ArrayList<>();
		orderDishesList.add(new OrderDishes(26, 5.0));
		orderDishesList.add(new OrderDishes(1, 30.0));
		
		Orders order = new Orders();
		orderService.createOrder(order, tmpUser, orderDishesList);
	}

	@Test
	public void testGetOrdersList() {
		orderService.getOrdersList().stream().forEachOrdered(x -> System.out.println(x));
		assertTrue(orderService.getOrdersList().size() >= 1);
	}

	@Test
	public void testSetStatusAsDone() {
		orderService.setStatusAsDone(1);
		assertTrue(orderService.findById(1).getStatus().equals("done"));
	}

	@Test
	public void testFindById() {
		assertNotNull(orderService.findById(1));
	}

}
