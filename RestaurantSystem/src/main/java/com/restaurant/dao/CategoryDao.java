package com.restaurant.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface for treating, creating new  data 
 * about categories.  
 * 
 * @author Tribel
 *
 */
public interface CategoryDao {
	
	/**
	 * Returning category id of particular category by name.
	 * @param a connection {@link Connection} (session) with a specific database
	 * @param name {@link String} of dish category
	 * @return id of needed category 
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection
	 */
	public int getCategoryIdByName(Connection connection, String name) throws SQLException;
	
	/**
	 * Returning full list of categories that currently exist. 
	 * @param a connection {@link Connection} (session) with a specific database 
	 * @return  {@link List<String>} full category list
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection
	 */
	public List<String> getAllCategoryList(Connection connection) throws SQLException;

}
