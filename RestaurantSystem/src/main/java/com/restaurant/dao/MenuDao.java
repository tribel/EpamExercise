package com.restaurant.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.restaurant.entity.Menu;

public interface MenuDao {

	/**
	 * Get all dishes list
	 * @param connection
	 * @return full {@code List<Menu>} all of the dishes
	 * @throws SQLException
	 */
	public List<Menu> getAllMenuList(Connection connection) throws SQLException;
	
	/**
	 *  Returning dishes list by category id
	 * @param connection
	 * @param categoryId id of exact category
	 * @return {@code List<Menu>} dishes list by exact category id 
	 * @throws SQLException
	 */
	public List<Menu> getMenuListByCategoryId(Connection connection, int categoryId) throws SQLException;
	
	/**
	 * Saving dish to data base
	 * @param connection
	 * @param menu entity that will be save
	 * @throws SQLException
	 */
	public void saveDish(Connection connection, Menu menu) throws SQLException;
	
	/**
	 * Get dish entity by id
	 * @param connection
	 * @param id of the dish entity
	 * @return {@code Menu} entity 
	 * @throws SQLException
	 */
	public Menu getById(Connection connection, int id) throws SQLException;
}
