package com.restaurant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.dao.UsersDao;
import com.restaurant.entity.Users;


/**
 * Implementation of {@link UsersDao} interface.
 * @author Tribel
 *
 */
public class UsersDaoImpl implements UsersDao{

	private static final Logger logger = LogManager.getLogger(UsersDaoImpl.class);
	
	private static final String SQL_INSERT_USERS = "insert into Users(name, email, address, roleId ,login ,password) "
													+ "values(?, ? ,? ,? ,? ,? )";
	private static final String SQL_AUTHORIZE = "Select * From Users u Where u.login = ? AND u.password = ?";
	private static final String SQL_UPDATE_USER = "Update Users SET name = ?, email = ?, address = ?, "
													+ "	login = ?, password = ? WHERE id = ?";
	private static final String SQL_GET_BY_ID = "Select * From Users u WHERE u.id = ?";
	private static final String SQL_GET_ALL  = "Select * From Users u Where u.roleId <> 1";
	private static final String SQL_GET_ROLE_BY_ID = "Select name From Role r Where r.id = ?";
	
	@Override
	public void registration(Connection connection, Users user) throws SQLException {
		
		try(PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USERS)) {	
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getAddress());
			statement.setInt(4, user.getRoleId());
			statement.setString(5, user.getLogin());
			statement.setString(6, user.getPassword());
			statement.executeUpdate();
			
		} catch(SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
	}

	@Override
	public Users authorize(Connection connection, String login, String password) throws SQLException {
		Users user = null;
		try (	PreparedStatement statement = connection.prepareStatement(SQL_AUTHORIZE)) {
			statement.setString(1, login);
			statement.setString(2, password);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				user = new Users();
				user.setId(set.getInt("id"));
				user.setName(set.getString("name"));
				user.setEmail(set.getString("email"));
				user.setAddress(set.getString("address"));
				user.setRoleId(set.getInt("roleId"));
				user.setLogin(set.getString("login"));
				user.setPassword(set.getString("password"));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		return user;
	}

	@Override
	public void editUserProfile(Connection connection, Users user) throws SQLException {
		try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER)) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getLogin());
			statement.setString(5, user.getPassword());
			statement.setInt(6, user.getId());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public Users getUserById(Connection connection, int id) throws SQLException {
		Users user = null;
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_BY_ID)) {
		
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				user = new Users();
				user.setId(set.getInt("id"));
				user.setName(set.getString("name"));
				user.setEmail(set.getString("email"));
				user.setAddress(set.getString("address"));
				user.setRoleId(set.getInt("roleId"));
				user.setLogin(set.getString("login"));
				user.setPassword(set.getString("password"));
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return user;
	}

	@Override
	public List<Users> getUsersList(Connection connection) throws SQLException {
		List<Users> usersList = new ArrayList<>();
		
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL);) {
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				Users user = new Users();
				user.setId(set.getInt("id"));
				user.setName(set.getString("name"));
				user.setEmail(set.getString("email"));
				user.setAddress(set.getString("address"));
				user.setRoleId(set.getInt("roleId"));
				user.setLogin(set.getString("login"));
				user.setPassword(set.getString("password"));
				usersList.add(user);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return usersList;
	}

	@Override
	public String getRoleNameById(Connection connection, int id) throws SQLException {
		String result = null;
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ROLE_BY_ID)) {
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();

			while(set.next()) {
				result = set.getString("name");
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return result;
	}

	
}
