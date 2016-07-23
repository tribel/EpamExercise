package com.restaurant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.dao.MenuDao;
import com.restaurant.entity.Menu;

public class MenuDaoImpl implements MenuDao{
	
	private static final Logger logger = LogManager.getLogger(MenuDaoImpl.class);
	
	private static final String SQL_GET_ALL_MENU = "SELECT * FROM MENU";
	private static final String SQL_GET_BY_CATEGORY = "SELECT * FROM Menu m WHERE m.categoryId = ?";
	private static final String SQL_INSERT = "insert into Menu (name, price , categoryId) values(? , ? , ?)";
	private static final String SQL_GET_BY_ID = "Select * From Menu m Where m.id = ?";
	
	@Override
	public List<Menu> getAllMenuList(Connection connection) throws SQLException {
		List<Menu> menuList = new ArrayList<>();
		
		try (Statement statement = connection.createStatement()){
			ResultSet set = statement.executeQuery(SQL_GET_ALL_MENU);
			
			while(set.next()) {
				Menu menu = new Menu();
				menu.setId(set.getInt("id"));
				menu.setName(set.getString("name"));
				menu.setPrice(set.getDouble("price"));
				menu.setCategoryId(set.getInt("categoryId"));
				menuList.add(menu);
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		return menuList;
	}

	@Override
	public List<Menu> getMenuListByCategoryId(Connection connection, int categoryId) throws SQLException {
		List<Menu> menuList = new ArrayList<>();
		
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_BY_CATEGORY)){
			statement.setInt(1, categoryId);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				Menu menu = new Menu();
				menu.setId(set.getInt("id"));
				menu.setName(set.getString("name"));
				menu.setPrice(set.getDouble("price"));
				menu.setCategoryId(set.getInt("categoryId"));
				menuList.add(menu);
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		return menuList;
	}

	@Override
	public void saveDish(Connection connection, Menu menu) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {	
			statement.setString(1, menu.getName());
			statement.setDouble(2, menu.getPrice());
			statement.setInt(3, menu.getCategoryId());
			statement.executeUpdate();
			
		} catch(SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
	}

	@Override
	public Menu getById(Connection connection, int id) throws SQLException {
		Menu menu = null;
		
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_BY_ID)){
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				menu = new Menu();
				menu.setId(set.getInt("id"));
				menu.setName(set.getString("name"));
				menu.setPrice(set.getDouble("price"));
				menu.setCategoryId(set.getInt("categoryId"));
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		return menu;
	}
	
	
}
