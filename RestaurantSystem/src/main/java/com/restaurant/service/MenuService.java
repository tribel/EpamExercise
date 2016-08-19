package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.Menu;

/**
 * This interface declare menu service . It contain methods 
 * that search , set and create entities for menu.
 * @author Tribel
 *
 */
public interface MenuService {

	/**
	 * Returning full menu list.
	 * @return {@link List} of all dishes entities. 
	 */
	public List<Menu> getAllMenuList();

	/**
	 * Returning menu list that, in which dishes have the passed category.
	 * @param categoryName {@link String} name of category
	 * @return {@link List} of dishes entities. 
	 */
	public List<Menu> getMenuListByName(String categoryName);

	/**
	 * Saving dish entity to menu
	 * @param menu {@link Menu} instance.
	 */
	public void saveDish(Menu menu);
	
	/**
	 * Returning entire category  list
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
