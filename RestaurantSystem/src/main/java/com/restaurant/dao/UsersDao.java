package com.restaurant.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



import com.restaurant.entity.Role;
import com.restaurant.entity.Users;

/**
 * Interface for treating, creating new for 
 * Users table in data base.
 * @author Tribel
 *
 */
public interface UsersDao {
	
	/**
	 * Save new user in data base.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param  {@link Users} instance that will be saved in data base
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public void registration(Connection connection, Users user) throws SQLException;
	
	/**
	 * Authorizing already exist user, returning user instance. 
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param login {@code String} of user.
	 * @param password {@code String} of user.
	 * @return {@code User} that have define login and password
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public Users authorize(Connection connection, String login, String password) throws SQLException;
	
	/**
	 * Edit fields in user object that will be pass in data base
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param user object that will be change
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public void editUserProfile(Connection connection, Users user) throws SQLException;
	
	/**
	 * Returning user object by id.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param id of particular user.
	 * @return {@link Users} instance which has exact id.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public Users getUserById(Connection connection, int id) throws SQLException;
	
	/**
	 * Return all user list.
	 * @param connection {@link Connection} (session) with a specific database.
	 * @return {@link List} of users.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public List<Users> getUsersList(Connection connection) throws SQLException;

	/**
	 *  Returning role name by exact id. 
	 * @param connection {@link Connection} (session) with a specific database.
	 * @param id of particular {@link Role}.
	 * @return {@code String} role name.
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection.
	 */
	public String getRoleNameById(Connection connection, int id) throws SQLException;
}
