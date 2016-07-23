package com.restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.restaurant.entity.OrderDishes;
import com.restaurant.entity.Orders;
import com.restaurant.entity.Users;
import com.restaurant.service.impl.OrdersServiceImpl;

public class OrdersServiceImplTest {

	private OrdersService orderService = new OrdersServiceImpl(null, null, null);
	
	@Test
	@Ignore
	public void testCreateOrder() {
		Users tmpUser = new Users("test", "test");
		List<OrderDishes> orderDishesList = new ArrayList<>();
		orderDishesList.add(new OrderDishes(26, 5.0));
		orderDishesList.add(new OrderDishes(1, 30.0));
		
		Orders order = new Orders();
		orderService.createOrder(order, tmpUser, orderDishesList);
	}

	@Test
	@Ignore
	public void testGetOrdersList() {
		orderService.getOrdersList().stream().forEachOrdered(x -> System.out.println(x));
	}

	@Test
	@Ignore
	public void testSetStatusAsDone() {
		orderService.setStatusAsDone(8);
	}

	@Test
	//@Ignore
	public void testFindById() {
		System.out.println(orderService.findById(8));
	}

}
