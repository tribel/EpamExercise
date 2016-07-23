package com.restaurant.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.restaurant.entity.Users;

public interface UsersDao {
	
	/**
	 * Registration new user
	 * @param connection sql {@code Connection}
	 * @param user object that will be saved in data base
	 * @throws SQLException
	 */
	public void registration(Connection connection, Users user) throws SQLException;
	
	/**
	 * Authorizing already exist user 
	 * @param connection sql {@code Connection}
	 * @param login {@code String} of user
	 * @param password {@code String} of user
	 * @return {@code User} that have define login and password
	 * @throws SQLException
	 */
	public Users authorize(Connection connection, String login, String password) throws SQLException;
	
	/**
	 * Edit fields in user object that will be pass in data base
	 * @param connection sql {@code Connection}
	 * @param user object that will be change
	 * @throws SQLException
	 */
	public void editUserProfile(Connection connection, Users user) throws SQLException;
	
	/**
	 * Get user object by id
	 * @param connection sql {@code Connection}
	 * @param id {@code int} user 
	 * @return user object
	 * @throws SQLException
	 */
	public Users getUserById(Connection connection, int id) throws SQLException;
	
	/**
	 * Return all user list
	 * @param connection
	 * @return users list
	 * @throws SQLException
	 */
	public List<Users> getUsersList(Connection connection) throws SQLException;

	/**
	 *  Get role name by exact id 
	 * @param connection
	 * @param id {@code int} role
	 * @return {@code String} role name
	 * @throws SQLException
	 */
	public String getRoleNameById(Connection connection, int id) throws SQLException;
}
