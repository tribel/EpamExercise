package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.Menu;

public interface MenuService {

	/**
	 * All of menu list returning
	 * @return {@link Menu}  {@link List} entity of all the menu 
	 */
	public List<Menu> getAllMenuList();

	/**
	 * All menu list by category
	 * @param categoryName {@link String} name of category
	 * @return {@link Menu}  {@link List} entity by category 
	 */
	public List<Menu> getMenuListByName(String categoryName);

	/**
	 * Saving dish entity to menu
	 * @param menu {@link Menu} entity
	 */
	public void saveDish(Menu menu);
	
	/**
	 * Returning of all category 
	 * @return {@link String} {@link List} of category
	 */
	public List<String> getAllCategoryList() ;
	
	/**
	 * Dish by exact id
	 * @param id of dish entity
	 * @return {@link Menu} entity with exact id
	 */
	public Menu getById(int id);
	
}
