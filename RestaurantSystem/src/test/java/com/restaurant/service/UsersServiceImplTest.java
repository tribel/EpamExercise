package com.restaurant.service;

import org.junit.Ignore;
import org.junit.Test;

import com.restaurant.entity.Users;
import com.restaurant.service.impl.UsersServiceImpl;

public class UsersServiceImplTest {

	private UsersService usersService = new UsersServiceImpl(null);
	
	@Test
	@Ignore
	public void testRegistration() {
		Users users = new Users("TestMan", "test@gmail", "testAddress", "test", "test");
		usersService.registration(users);
	}

	@Test
	@Ignore
	public void testAuthorize() {
		Users users = usersService.authorize("test", "test");
		System.out.println(users);
	}

	@Test
	@Ignore
	public void testEditUserProfile() {
		Users users = usersService.authorize("test", "test");
		users.setEmail("testUpdate@yahoo.com");
		usersService.editUserProfile(users);
	}

	@Test
	@Ignore
	public void testGetUserById() {
		System.out.println(usersService.getUserById(30));
	}

	@Test
	@Ignore
	public void testGetUsersList() {
		usersService.getUsersList().stream().forEach(x -> System.out.println(x));
	}

	@Test
	public void testGetRoleNameById() {
		System.out.println(usersService.getRoleNameById(2));
	}
	
}
