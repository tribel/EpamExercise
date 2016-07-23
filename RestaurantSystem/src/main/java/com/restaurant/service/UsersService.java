package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.Users;

public interface UsersService {
	
	/**
	 * Registration new user
	 * @param user entity that want to create
	 */
	public void registration(Users user);
	
	/**
	 * Authorizing already existing user 
	 * @param user {@link String} login  
	 * @param user {@link String} password  
	 * @return {@link Users} entity , that have authorize
	 */
	public Users authorize(String login, String password);
	
	/**
	 * Changing already existing user entity
	 * @param user entity
	 */
	public void editUserProfile(Users user);
	
	/**
	 * Returning user entity by exact id
	 * @param user id 
	 * @return {@link Users} entity
	 */
	public Users getUserById(int id);
	
	/**
	 * Returning all user list
	 * @return {@link Users} {@link List}
	 */
	public List<Users> getUsersList();
	
	/**
	 * Returning role by id
	 * @param id role id
	 * @return {@link String} role name
	 */
	public String getRoleNameById(int id);
	
}
