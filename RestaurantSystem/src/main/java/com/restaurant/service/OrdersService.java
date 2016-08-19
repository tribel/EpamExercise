package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.OrderDishes;
import com.restaurant.entity.Orders;
import com.restaurant.entity.Users;

/**
 * This interface declare order service.
 * It contains creating order method , change and 
 * searching by some feature methods. 
 * @author Tribel
 *
 */
public interface OrdersService {
	
	/**
	 *  Method for creating new order.
	 * @param order new instance
	 * @param current {@link Users} instance
	 * @param odList already added dishes to cart list
	 */
	public void createOrder(Orders order, Users users, List<OrderDishes> odList);
	
	/**
	 * Returning active orders list
	 * @return {@link List} {@link Orders} in which status is absent. 
	 */
	public List<Orders> getOrdersList();
	
	/**
	 * Set order status as done.
	 * @param concrete order id.
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
	
	/**
	 * Marked exact order with exact id like 'denial', and means 
	 * that administrator has rejected  the order. 
	 * @param orderId {@link Integer} id of the order that will be marked like 'denial'.
	 */
	public void setStatusAsDenial(int orderId);
	
	public List<Orders> getHistory();
}	
