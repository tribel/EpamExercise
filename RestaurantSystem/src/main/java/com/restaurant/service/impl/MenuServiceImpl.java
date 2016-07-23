package com.restaurant.service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.dao.CategoryDao;
import com.restaurant.dao.MenuDao;
import com.restaurant.entity.Menu;
import com.restaurant.service.MenuService;
import com.restaurant.service.transaction.TransactionWrapper;

public class MenuServiceImpl implements MenuService{

	private static final Logger logger = LogManager.getLogger(MenuServiceImpl.class);
	
	private MenuDao menuDao;
	private CategoryDao categoryDao;
	
	public MenuServiceImpl(MenuDao menuDao, CategoryDao categoryDao) {
		this.menuDao = menuDao;
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Menu> getAllMenuList() {
		logger.info("Select data from Menu table");
		return new TransactionWrapper().beginTransaction((Connection conn) -> {
			return menuDao.getAllMenuList(conn);
		});
	}

	@Override
	public List<Menu> getMenuListByName(String categoryName) {
		logger.info("Select data from Menu table");
		
		return new TransactionWrapper().beginTransaction((Connection conn) -> {
			int categoryId = categoryDao.getCategoryIdByName(conn ,categoryName);
			return menuDao.getMenuListByCategoryId(conn , categoryId);
		});
		
	}

	@Override
	public void saveDish(Menu menu) {
		logger.info("Saving new dish");
		
		 new TransactionWrapper().beginTransaction((Connection conn) -> {
			menuDao.saveDish(conn, menu);
			return null;
		});
	}

	@Override
	public List<String> getAllCategoryList() {
		logger.info("Select data from Category table");
		
		return new TransactionWrapper().beginTransaction((Connection conn) -> {
			return categoryDao.getAllCategoryList(conn);
		});
	}

	@Override
	public Menu getById(int id) {
		logger.info("Select data from Menu table");
		
		return new TransactionWrapper().beginTransaction((Connection conn) -> {
			return menuDao.getById(conn, id);
		});	
		
	}

}
