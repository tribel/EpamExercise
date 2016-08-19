package com.restaurant.service;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.junit.Before;
import org.junit.Test;

import com.restaurant.dao.CategoryDao;
import com.restaurant.dao.MenuDao;
import com.restaurant.entity.Category;
import com.restaurant.entity.Menu;
import com.restaurant.service.impl.MenuServiceImpl;

public class MenuServiceImplTest {

	 MenuDao menuDao = new MenuDao() {
		
		private List<Menu> list = new ArrayList<>();
		
		@Override
		public void saveDish(Connection connection, Menu menu) throws SQLException {
			list.add(menu);
		}
		
		@Override
		public List<Menu> getMenuListByCategoryId(Connection connection,
				int categoryId) throws SQLException {

			return list.stream().filter(o -> o.getCategoryId() == categoryId).collect(Collectors.toList());
		}
		
		@Override
		public Menu getById(Connection connection, int id) throws SQLException {
			return list.stream().findFirst().filter(o -> o.getId() == id).get();
		}
		
		@Override
		public List<Menu> getAllMenuList(Connection connection) throws SQLException {
			return list;
		}
	};
	
	 CategoryDao categoryDao = new CategoryDao() {
		
		private List<Category> categories = new ArrayList<>();
		
		{
			categories.add(new Category(1, "first category"));
			categories.add(new Category(2, "second category"));
			categories.add(new Category(3, "third category"));
		}
		
		@Override
		public int getCategoryIdByName(Connection connection, String name)
				throws SQLException {
			
			return categories.stream().findFirst()
									  .filter(o -> o.getName()
									  .equals(name)).get().getId();
		}
		
		@Override
		public List<String> getAllCategoryList(Connection connection)
				throws SQLException {
			
			return categories.stream().map(x -> x.getName()).collect(Collectors.toList());
		}
	};
	
	
	
	private MenuService menuService = new MenuServiceImpl(menuDao, categoryDao, new TransactionWrapperTest());

	@Before
	public void init() throws SQLException {
		menuDao.saveDish(null, new Menu(0, 12.3, "first name", 1));
		menuDao.saveDish(null, new Menu(1, 45.0, "second name", 2));
		menuDao.saveDish(null, new Menu(2, 21.5, "third name", 1));
		menuDao.saveDish(null, new Menu(3, 87.5, "fourth name", 3));
		
		
	}
	
	@Test
	public void testGetAllMenuList() {
		System.out.println(menuService.getAllMenuList());
		assertTrue(menuService.getAllMenuList().size() == 4);
	}
	
	@Test
	public void testGetMenuListByCategoryName() {
		List<Menu> list = menuService.getMenuListByName("first category");
		assertTrue(list.size() == 2);
	}

	@Test
	public void getById() {
		assertTrue(menuService.getById(0).getName().equals("first name"));
	}
	
	
}
