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

/**
 * This class implements {@link MenuService} interface.
 * @author Tribel
 *
 */
public class MenuServiceImpl implements MenuService{

	private static final Logger logger = LogManager.getLogger(MenuServiceImpl.class);
	
	private MenuDao menuDao;
	private CategoryDao categoryDao;
	private TransactionWrapper transactionWrapper;
	
	/**
	 * Constructs {@link MenuServiceImpl} instance, with special parameters.
	 * @param menuDao {@link MenuDao} instance.
	 * @param categoryDao {@link CategoryDao} instance.
	 * @param transactionWrapper {@link TransactionWrapper} instance, that create transaction execution and 
	 * wrappers all method in it.
	 */
	public MenuServiceImpl(MenuDao menuDao, CategoryDao categoryDao, TransactionWrapper transactionWrapper) {
		this.menuDao = menuDao;
		this.categoryDao = categoryDao;
		this.transactionWrapper = transactionWrapper;
	}

	@Override
	public List<Menu> getAllMenuList() {
		logger.info("Select data from Menu table");
		return transactionWrapper.beginTransaction((Connection conn) -> {
			return menuDao.getAllMenuList(conn);
		});
	}

	@Override
	public List<Menu> getMenuListByName(String categoryName) {
		logger.info("Select data from Menu table");
		
		return transactionWrapper.beginTransaction((Connection conn) -> {
			int categoryId = categoryDao.getCategoryIdByName(conn ,categoryName);
			return menuDao.getMenuListByCategoryId(conn , categoryId);
		});
		
	}

	@Override
	public void saveDish(Menu menu) {
		logger.info("Saving new dish");
		
		 transactionWrapper.beginTransaction((Connection conn) -> {
			menuDao.saveDish(conn, menu);
			return null;
		});
	}

	@Override
	public List<String> getAllCategoryList() {
		logger.info("Select data from Category table");
		
		return transactionWrapper.beginTransaction((Connection conn) -> {
			return categoryDao.getAllCategoryList(conn);
		});
	}

	@Override
	public Menu getById(int id) {
		logger.info("Select data from Menu table");
		
		return transactionWrapper.beginTransaction((Connection conn) -> {
			return menuDao.getById(conn, id);
		});	
		
	}

}
