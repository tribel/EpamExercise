package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.OrderDishes;

public interface OrderDishesService {

	/**
	 * List by id
	 * @param id of {@link OrderDishes} entity
	 * @return {@link OrderDishes} {@link List} by id
	 */
	public List<OrderDishes> findByOrderId(int id);

	/**
	 * Sum of all the dishes in order
	 * @param orderId id of order
	 * @return total {@link Double} sum
	 */
	public double getTotalOrderPrice(int orderId);


}
