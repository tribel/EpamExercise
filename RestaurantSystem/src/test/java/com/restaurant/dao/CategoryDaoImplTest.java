package com.restaurant.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.restaurant.dao.CategoryDao;
import com.restaurant.dao.impl.CategoryDaoImpl;

public class CategoryDaoImplTest {

	private CategoryDao categoryDao = new CategoryDaoImpl();
	
	@Test
	public void testGetCategoryNameById() {
		try {
			
			assertEquals(1, categoryDao.getCategoryIdByName(null, "meat"));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
