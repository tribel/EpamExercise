package com.restaurant.dao.impl;

import com.restaurant.dao.CategoryDao;
import com.restaurant.dao.DaoFactory;
import com.restaurant.dao.MenuDao;
import com.restaurant.dao.OrderDishesDao;
import com.restaurant.dao.OrdersDao;
import com.restaurant.dao.UsersDao;

/**
 * This class implements DAO factory for JDBC connection.
 * @author Tribel
 *
 */
public class DerbyDaoFactory extends DaoFactory {

	@Override
	public CategoryDao getCategoryDao() {
		return new CategoryDaoImpl();
	}

	@Override
	public MenuDao getMenuDao() {
		return new MenuDaoImpl();
	}

	@Override
	public OrdersDao getOrdersDao() {
		return new OrdersDaoImpl();
	}

	@Override
	public OrderDishesDao getOrderDishesDao() {
		return new OrderDishesDaoImpl();
	}

	@Override
	public UsersDao getUsersDao() {
		return new UsersDaoImpl();
	}

}
