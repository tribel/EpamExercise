package com.restaurant.service.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface for creating transaction wrapper 
 * @author Tribel
 *
 * @param <T> entity that will be returning by executing method
 */

@FunctionalInterface
public interface Operation<T> {

	/**
	 * Callback function that realized transaction context
	 * @param connection entity
	 * @return <T> 
	 * @throws SQLException
	 */
	public T execute(Connection connection) throws SQLException;
}
