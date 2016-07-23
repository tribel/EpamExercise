package com.restaurant.service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.dao.UsersDao;
import com.restaurant.entity.Users;
import com.restaurant.service.UsersService;
import com.restaurant.service.transaction.TransactionWrapper;

public class UsersServiceImpl implements UsersService {

	private static final Logger logger = LogManager.getLogger(UsersServiceImpl.class);
	
	private UsersDao usersDao;
	
	public UsersServiceImpl(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public void registration(Users user) {
		logger.info("User registration");
		new TransactionWrapper().beginTransaction((Connection conn) -> {
			usersDao.registration(conn, user);
			return null;
		});
	}

	@Override
	public Users authorize(String login, String password) {
		logger.info("User authorizing ");
		return new TransactionWrapper().beginTransaction((Connection conn) -> {
			return usersDao.authorize(conn, login, password);
		});
	}

	@Override
	public void editUserProfile(Users user) {
		logger.info("Change user profile");
		new TransactionWrapper().beginTransaction((Connection conn) -> {
			usersDao.editUserProfile(conn, user);
			return null;
		});
		
	}

	@Override
	public Users getUserById(int id) {
		logger.info("Select data from Users table");
		return new TransactionWrapper().beginTransaction((Connection conn) -> {
			return usersDao.getUserById(conn , id);
		});

	}

	@Override
	public List<Users> getUsersList() {
		logger.info("Select data from Users table");
		return new TransactionWrapper().beginTransaction((Connection conn) -> {
			return usersDao.getUsersList(conn);
		});
	}

	@Override
	public String getRoleNameById(int id) {
		logger.info("Select data from Role table");
		return new TransactionWrapper().beginTransaction((Connection conn) -> {
			return usersDao.getRoleNameById(conn, id);
		});
			

	}

}
