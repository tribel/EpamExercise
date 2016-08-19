package com.restaurant.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.restaurant.entity.OrderDishes;

/**
 * This interface declare order dishes service.
 * It contains searching entities by id and calculating 
 * order total price methods. 
 * @author Tribel
 *
 */
public interface OrderDishesService {

	/**
	 * Returning {@link OrderDishes} list by id.
	 * @param order id of {@link OrderDishes} entity
	 * @return {@link OrderDishes} {@link List} by id, with passed order id.
	 */
	public List<OrderDishes> findByOrderId(int id);

	/**
	 * Calculating the order total price.
	 * @param id of the particular order.
	 * @return total order {@link Double} sum.
	 */
	public double getTotalOrderPrice(int orderId);


	public int getMenuListByOrderID(int id);
}
