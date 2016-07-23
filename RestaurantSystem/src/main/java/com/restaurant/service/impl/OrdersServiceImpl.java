package com.restaurant.service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.dao.OrderDishesDao;
import com.restaurant.dao.OrdersDao;
import com.restaurant.dao.UsersDao;
import com.restaurant.entity.OrderDishes;
import com.restaurant.entity.Orders;
import com.restaurant.entity.Users;
import com.restaurant.service.OrdersService;
import com.restaurant.service.transaction.TransactionWrapper;

public class OrdersServiceImpl implements OrdersService {

	private static final Logger logger = LogManager.getLogger(OrdersService.class);
	
	private OrdersDao ordersDao;;
	private OrderDishesDao orderDishesDao;
	private UsersDao usersDao;
	
	public OrdersServiceImpl(OrdersDao ordersDao,
			OrderDishesDao orderDishesDao, UsersDao usersDao) {
		
		this.ordersDao = ordersDao;
		this.orderDishesDao = orderDishesDao;
		this.usersDao = usersDao;
	}

	@Override
	public void createOrder(Orders order, Users users, List<OrderDishes> odList) {
		logger.info("Creating Order");
		new TransactionWrapper().beginTransaction((Connection ds) -> {
			Users tmpUser = usersDao.authorize(ds, users.getLogin(), users.getPassword());
			if(tmpUser != null) {
				order.setUserId(tmpUser.getId());
			}
			
			Orders tmpOrder = ordersDao.createOrder(ds, order);
			for (OrderDishes od : odList) {
				od.setOrderId(tmpOrder.getId());
				orderDishesDao.add(ds, od);
			}
			
			return null;
		});
		
		
	}

	@Override
	public List<Orders> getOrdersList() {
		logger.info("Select data from Order table");
		return new TransactionWrapper().beginTransaction((Connection ds) -> {
			return ordersDao.getOrdersList(ds);
		}); 	
	}

	@Override
	public void setStatusAsDone(int orderId) {
		logger.info("Change order status");
		 new TransactionWrapper().beginTransaction((Connection ds) -> {
			ordersDao.setStatusAsDone(ds, orderId);
			return null;
		}); 
		
	}

	@Override
	public Orders findById(int id) {
		logger.info("Select data from Order table");	
		return new TransactionWrapper().beginTransaction((Connection ds) -> {
			return ordersDao.findById(ds, id);
		});
		
	}

	@Override
	public void setStatusAsPaid(int orderId) {
		logger.info("Change order status as paid");
		new TransactionWrapper().beginTransaction((Connection ds) -> {
			ordersDao.setStatusAsPaid(ds, orderId);
			return null;
		});
	}

	@Override
	public List<Orders> getDoneOrdersList(int userId) {
		logger.info("Select data from Orders table");
		 return new TransactionWrapper().beginTransaction((Connection ds) -> {
			return ordersDao.getDoneOrdersList(ds, userId);
		});
	}

}
