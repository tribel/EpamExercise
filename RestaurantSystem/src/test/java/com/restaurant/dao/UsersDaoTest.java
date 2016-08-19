package com.restaurant.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Test;

import com.restaurant.dao.MyConnection;
import com.restaurant.dao.impl.UsersDaoImpl;
import com.restaurant.entity.Users;

public class UsersDaoTest {
	
	private UsersDao usersDao = new UsersDaoImpl();
	
	@Test
	public void testRegistration() throws IOException, SQLException {
		Connection connection = MyConnection.getConnection();
		connection.setAutoCommit(false);
		try {

			Users users = new Users("GumenNA", "gumen@gmail.com", "kiev", "gumenka", "1234");
			usersDao.registration(null, users);
			Assert.assertTrue(usersDao.getUsersList(null).contains(users));
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			connection.rollback();
			connection.close();;
			
		}
	}
	
	
	@Test
	public void testAuthorize() throws IOException, SQLException {
		Connection connection = MyConnection.getConnection();
		connection.setAutoCommit(false);
		try {
			Users users = new Users("Alex", "alex@gmail.com", "kiev", "alex", "1234");
			usersDao.registration(null, users);
			Users signInUser = usersDao.authorize(null , users.getLogin(), users.getPassword());
			Assert.assertEquals(users, signInUser);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			connection.rollback();
			connection.close();;
		}
	}
	
	public void testEditUserProfile() {
		
	}
	
	
	@Test
	public void testGetUserById() {
		try (Connection connection = MyConnection.getConnection()){
			System.out.println(usersDao.getUserById(null, 3));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testGetUsersList() {
		
		try (Connection connection = MyConnection.getConnection()){
			System.out.println(usersDao.getUsersList(null));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void testGetRoleNameById() {
		
		try (Connection connection = MyConnection.getConnection()){
			Assert.assertEquals("admin", usersDao.getRoleNameById(null, 1));
			Assert.assertEquals("user", usersDao.getRoleNameById(null, 2));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
