package com.restaurant.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import com.restaurant.dao.impl.CategoryDaoImpl;
import com.restaurant.dao.impl.MenuDaoImpl;
import com.restaurant.dao.MyConnection;
import com.restaurant.entity.Menu;


public class MenuDaoTest {

	private MenuDao menuDao = new MenuDaoImpl();
	
	@Test
	@Ignore
	public void testGetAllMenuList() throws IOException, SQLException {
		Connection connection = MyConnection.getConnection();
		connection.setAutoCommit(false);
		try {
			Menu menuTets = new Menu(10.0, "testMeat", 1);
			menuDao.saveDish(null ,menuTets);	
			Assert.assertTrue(menuDao.getAllMenuList(null).contains(menuTets));
	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			connection.rollback();
			connection.close();;
		}
	}
	
	@Test
	@Ignore
	public void testGetMenuListByCategoryId() throws IOException, SQLException {
		Connection connection = MyConnection.getConnection();
		connection.setAutoCommit(false);
		try {
			
			System.out.println(menuDao.getMenuListByCategoryId(null, 1));
	
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			connection.rollback();
			connection.close();;
		}
	}
	
	@Test
	@Ignore
	public void testSaveDish() throws SQLException {
		Connection connection = MyConnection.getConnection();
		connection.setAutoCommit(false);
		try {
			Menu menu = new Menu(10.0, "chokolade pie", 3);
			menuDao.saveDish(null, menu);
			Assert.assertTrue(menuDao.getAllMenuList(null).contains(menu));
			System.out.println(menuDao.getAllMenuList(null));
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			connection.rollback();
			connection.close();;
		}
	}
	
	@Test
	public void testGetAllCategoryList() throws SQLException {
		//Connection connection = MyConnection.getConnection();
		CategoryDao categoryDao = new CategoryDaoImpl();
		System.out.println(categoryDao.getAllCategoryList(null));
	}
	
}
