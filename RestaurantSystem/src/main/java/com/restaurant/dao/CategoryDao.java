package com.restaurant.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public interface CategoryDao {
	
	/**
	 * Returning category id by category name
	 * @param connection 
	 * @param name of dish category
	 * @return int category id
	 * @throws SQLException 
	 */
	public int getCategoryIdByName(Connection connection, String name) throws SQLException;
	
	/**
	 * 
	 * @param connection 
	 * @return {@code List<String> full category list}
	 * @throws SQLException
	 */
	public List<String> getAllCategoryList(Connection connection) throws SQLException;

}
