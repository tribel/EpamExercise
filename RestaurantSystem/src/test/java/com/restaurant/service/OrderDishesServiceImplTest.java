package com.restaurant.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.restaurant.service.impl.OrderDishesServiceImpl;

public class OrderDishesServiceImplTest {

	private OrderDishesService odService = new OrderDishesServiceImpl(null);
	
	@Test
	@Ignore
	public void testFindByOrderId() {
		System.out.println(odService.findByOrderId(1));
	
	}

	@Test
	@Ignore
	public void testGetTotalOrderPrice() {
		double tmpSum = odService.getTotalOrderPrice(1);
		assertEquals(tmpSum, 45.0, 0.001);
	}

}
