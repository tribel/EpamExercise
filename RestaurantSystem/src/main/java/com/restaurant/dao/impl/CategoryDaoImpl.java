package com.restaurant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.dao.CategoryDao;


public class CategoryDaoImpl implements CategoryDao {

	private static final Logger logger = LogManager.getLogger(CategoryDaoImpl.class);
	
	private static final String SQL_GET_NAME_BY_ID = "Select id  From Category c Where c.name = ?";
	private static final String SQL_GET_CATEGORY_LIST = "Select name From Category";
	
	@Override
	public int getCategoryIdByName(Connection connection, String name) throws SQLException {
		Integer result = null;
		
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_NAME_BY_ID)){		
			statement.setString(1, name);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				result = set.getInt("id");
			}
		
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}

	@Override
	public List<String> getAllCategoryList(Connection connection) throws SQLException {
		List<String> result = new ArrayList<>();
		
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_CATEGORY_LIST)){		
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				result.add(set.getString("name"));
			}
		
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}

}
