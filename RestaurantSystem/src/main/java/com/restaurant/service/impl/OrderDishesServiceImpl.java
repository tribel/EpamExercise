package com.restaurant.service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.dao.OrderDishesDao;
import com.restaurant.entity.OrderDishes;
import com.restaurant.service.OrderDishesService;
import com.restaurant.service.transaction.TransactionWrapper;

public class OrderDishesServiceImpl implements OrderDishesService {

	private static final Logger logger = LogManager.getLogger(OrderDishesServiceImpl.class);
	
	private OrderDishesDao orderDishesDao;
	
	public OrderDishesServiceImpl(OrderDishesDao orderDishesDao) {
		this.orderDishesDao = orderDishesDao;
	}

	@Override
	public List<OrderDishes> findByOrderId(int id) {
		logger.info("Select data from OrderDishes table");
		return new TransactionWrapper().beginTransaction((Connection conn) -> {
			return orderDishesDao.findByOrderId(conn, id);
		});
	}

	@Override
	public double getTotalOrderPrice(int orderId) {
		logger.info("Select data from OrderDishes table");	
		return new TransactionWrapper().beginTransaction((Connection conn) -> {
			return orderDishesDao.getTotalOrderPrice(conn, orderId);
		});
	}

}
