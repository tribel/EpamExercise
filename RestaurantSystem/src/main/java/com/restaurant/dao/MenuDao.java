package com.restaurant.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.restaurant.entity.Menu;

/**
 * Interface for treating, creating new menu data. 
 * @author Tribel
 *
 */
public interface MenuDao {

	/**
	 * Returning full dishes list existing in data base.
	 * @param connection {@link Connection} (session) with a specific database
	 * @return full {@code List<Menu>} of the dishes
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection
	 */
	public List<Menu> getAllMenuList(Connection connection) throws SQLException;
	
	/**
	 *  Returning dishes list by category id.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param categoryId - id of exact category, for further dish list.
	 * @return {@code List<Menu>} dishes list by exact category id 
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public List<Menu> getMenuListByCategoryId(Connection connection, int categoryId) throws SQLException;
	
	/**
	 * Saving new dish to data base.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param {@link Menu} instance that will be save.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public void saveDish(Connection connection, Menu menu) throws SQLException;
	
	/**
	 * Returning dish entity by particular id.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param id of the dish entity.
	 * @return {@code Menu} entity that have passed id.  
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public Menu getById(Connection connection, int id) throws SQLException;
}
