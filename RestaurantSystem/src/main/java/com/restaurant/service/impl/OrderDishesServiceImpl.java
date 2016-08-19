package com.restaurant.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.dao.OrderDishesDao;
import com.restaurant.entity.OrderDishes;
import com.restaurant.service.OrderDishesService;
import com.restaurant.service.transaction.TransactionWrapper;

/**
 * This class implements {@link OrderDishesService} interface.
 * @author Tribel
 *
 */
public class OrderDishesServiceImpl implements OrderDishesService {

	private static final Logger logger = LogManager.getLogger(OrderDishesServiceImpl.class);
	
	private OrderDishesDao orderDishesDao;
	private TransactionWrapper transactionWrapper;
	
	/**
	 * Constructs {@link OrderDishesServiceImpl} instance , with special parameters.
	 * @param orderDishesDao {@link OrderDishesDao} instance.
	 * @param transactionWrapper {@link TransactionWrapper} instance, that create transaction execution and 
	 * wrappers all method in it.
	 */
	public OrderDishesServiceImpl(OrderDishesDao orderDishesDao, TransactionWrapper transactionWrapper) {
		this.orderDishesDao = orderDishesDao;
		this.transactionWrapper = transactionWrapper;
	}

	@Override
	public List<OrderDishes> findByOrderId(int id) {
		logger.info("Select data from OrderDishes table");
		return transactionWrapper.beginTransaction((Connection conn) -> {
			return orderDishesDao.findByOrderId(conn, id);
		});
	}

	@Override
	public double getTotalOrderPrice(int orderId) {
		logger.info("Select data from OrderDishes table");	
		return transactionWrapper.beginTransaction((Connection conn) -> {
			return orderDishesDao.getTotalOrderPrice(conn, orderId);
		});
	}

	@Override
	public int getMenuListByOrderID( int id){
		
		return transactionWrapper.beginTransaction((Connection conn) -> {
			return orderDishesDao.getMenuListByOrderID(conn, id);
		});
	}

}
