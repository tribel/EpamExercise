package com.restaurant.dao;

import com.restaurant.dao.impl.DerbyDaoFactory;
import com.restaurant.exception.IncorrectIOCRealize;

/**
 * Abstract Factory for DAO 
 * 
 * @author Tribel
 */
public abstract class DaoFactory {
	
	public static final String DERBY = "derby";
	
	public abstract CategoryDao getCategoryDao();
	
	public abstract MenuDao getMenuDao();
	
	public abstract OrdersDao getOrdersDao();
	
	public abstract OrderDishesDao getOrderDishesDao();
	
	public abstract UsersDao getUsersDao();
	
	public static DaoFactory createDaoFactory(String srt){
		
		if(srt.equalsIgnoreCase(DERBY)) {
			return new DerbyDaoFactory();
		} else {
			throw new IncorrectIOCRealize();
		}
		
	}
}
