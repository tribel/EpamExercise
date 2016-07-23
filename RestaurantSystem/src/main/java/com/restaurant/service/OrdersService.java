package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.OrderDishes;
import com.restaurant.entity.Orders;
import com.restaurant.entity.Users;

public interface OrdersService {
	
	/**
	 *  Method for creating order
	 * @param order new instance
	 * @param users current user instance
	 * @param odList already added dishes to cart list
	 */
	public void createOrder(Orders order, Users users, List<OrderDishes> odList);
	
	/**
	 * Returning active orders list
	 * @return {@link List} {@link Orders}
	 */
	public List<Orders> getOrdersList();
	
	/**
	 * Set order status as done
	 * @param orderId order id
	 */
	public void setStatusAsDone(int orderId);
	
	/**
	 * Finding exact order by id
	 * @param id of order
	 * @return {@link Orders} entity
	 */
	public Orders findById(int id);
	
	/**
	 * Set order status as paid
	 * @param orderId order id
	 */
	public void setStatusAsPaid(int orderId);
	
	/**
	 * Returning done orders list
	 * @param userId {@link Users} entity id
	 * @return {@link Orders} {@link List}
	 */
	public List<Orders> getDoneOrdersList(int userId);
}	
