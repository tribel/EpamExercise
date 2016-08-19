package com.restaurant.service;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.restaurant.dao.UsersDao;
import com.restaurant.entity.Role;
import com.restaurant.entity.Users;
import com.restaurant.service.impl.UsersServiceImpl;

public class UsersServiceImplTest {

	UsersDao usersDao = new UsersDao() {
		
		List<Users> list = new ArrayList<>();
		
		{
			list.add(new Users("test", "test@test", "test", "test", "test"));
			list.add(new Users("test2", "test2@test2", "test2", "test2", "test2"));
			list.add(new Users("test3", "test3@test3", "test3", "test3", "test3"));
			for(int i = 0; i < list.size(); i++) {
				list.get(i).setId(i + 1);
			}
		}
		
		List<Role> roles = new ArrayList<>();
		
		{
			roles.add(new Role(1, "admin"));
			roles.add(new Role(2, "user"));
		}
		
		@Override
		public void registration(Connection connection, Users user)
				throws SQLException {
			if(user != null) list.add(user);
		}
		
		@Override
		public List<Users> getUsersList(Connection connection) throws SQLException {
			return list;
		}
		
		@Override
		public Users getUserById(Connection connection, int id) throws SQLException {
			return list.stream().filter(x -> x.getId() == id)
								.findFirst()
								.get();
		}
		
		@Override
		public String getRoleNameById(Connection connection, int id)
				throws SQLException {

			return roles.stream().filter(x -> x.getId() == id)
								 .findFirst()
								 .get()
								 .getName();
		}
		
		@Override
		public void editUserProfile(Connection connection, Users user)
				throws SQLException {

			int userIndex = 0;
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId() == user.getId()) {
					userIndex = i;
					break;
				}
			}
			
			list.set(userIndex, user);
		}
		
		@Override
		public Users authorize(Connection connection, String login, String password)
				throws SQLException {

			return list.stream().filter(x -> x.getLogin().equals(login))
								.filter(x -> x.getPassword().equals(password))
								.findFirst()
								.get();
		}
	};
	
	private UsersService usersService = new UsersServiceImpl(usersDao, new TransactionWrapperTest());
	
	
	@Before
	public void init() {
	
	}
	
	@Test
	public void testRegistration() {
		Users tmpUser = new Users("Junit", "Junit@Junit", "Junit", "Junit", "Junit");
		usersService.registration(tmpUser);
		
		//since the equals() method was overriding without id field
		// this statement should be true.
		assertTrue(usersService.getUsersList().contains(tmpUser));
	}

	@Test
	public void testAuthorize() {
		Users users = usersService.authorize("test", "test");
		assertTrue(users.getName().equals("test"));
	}

	@Test
	public void testEditUserProfile() {
		Users users = usersService.authorize("test", "test");
		users.setEmail("testUpdate@test.com");
		usersService.editUserProfile(users);
		
		users = usersService.authorize("test", "test");
		assertEquals("testUpdate@test.com", users.getEmail());
	}

	@Test
	public void testGetUserById() {
		assertEquals(usersService.getUserById(2).getName(), "test2");
	}

	@Test
	public void testGetUsersList() {
		usersService.getUsersList().stream().forEach(System.out::println);
	}

	@Test
	public void testGetRoleNameById() {
		assertEquals(usersService.getRoleNameById(1), "admin");
		assertEquals(usersService.getRoleNameById(2), "user");
	}
	
}
