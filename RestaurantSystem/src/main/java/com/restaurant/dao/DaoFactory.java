package com.restaurant.dao;

import com.restaurant.dao.impl.DerbyDaoFactory;
import com.restaurant.exception.IncorrectIOCRealize;

/**
 * Abstract Factory for DAO ,this class contains the 
 * access mechanism that requires to work with the data source.
 * 
 * @author Tribel
 */
public abstract class DaoFactory {
	
	public static final String DERBY = "derby";
	
	/**
	 * Creates object to access source of category data.
	 * @return {@link CategoryDao} implementation.
	 */
	public abstract CategoryDao getCategoryDao();
	
	/**
	 * Creates object to access source of menu data.
	 * @return {@link MenuDao} implementation. 
	 */
	public abstract MenuDao getMenuDao();
	
	/**
	 * Creates object to access source of orders data.
	 * @return {@link OrdersDao} implementation.
	 */
	public abstract OrdersDao getOrdersDao();
	
	/**
	 * Creates object to access source of order dishes data.
	 * @return {@link OrderDishesDao} implementation. 
	 */
	public abstract OrderDishesDao getOrderDishesDao();
	
	/**
	 * Creates object to access source of user data.
	 * @return {@link UsersDao} implementation. 
	 */
	public abstract UsersDao getUsersDao();
	
	/**
	 * Creates new instance of DAO factory. 
	 * @param particular {@link String} keyword of implementation.
	 * @return {@link DaoFactory} instance. 
	 */
	public static DaoFactory createDaoFactory(String srt){
		
		if(srt.equalsIgnoreCase(DERBY)) {
			return new DerbyDaoFactory();
		} else {
			throw new IncorrectIOCRealize();
		}
		
	}
}
