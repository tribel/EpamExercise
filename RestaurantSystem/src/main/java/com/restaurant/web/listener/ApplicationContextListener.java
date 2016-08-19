package com.restaurant.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.dao.CategoryDao;
import com.restaurant.dao.DaoFactory;
import com.restaurant.dao.MenuDao;
import com.restaurant.dao.OrderDishesDao;
import com.restaurant.dao.OrdersDao;
import com.restaurant.dao.UsersDao;
import com.restaurant.service.MenuService;
import com.restaurant.service.OrderDishesService;
import com.restaurant.service.OrdersService;
import com.restaurant.service.UsersService;
import com.restaurant.service.impl.MenuServiceImpl;
import com.restaurant.service.impl.OrderDishesServiceImpl;
import com.restaurant.service.impl.OrdersServiceImpl;
import com.restaurant.service.impl.UsersServiceImpl;
import com.restaurant.service.transaction.TransactionWrapper;


/**
 * Application context listener for initialization DAO factory ,services layer
 * and creation Transaction wrapper.  
 * @author Tribel
 *
 */
@WebListener
public class ApplicationContextListener implements ServletContextListener{

	private static final Logger logger = LogManager.getLogger(ApplicationContextListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("Context destroyed");
	}

	/**
	 * initialized DAO and services layers
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		
		//DAO
		MenuDao menuDao = DaoFactory.createDaoFactory(DaoFactory.DERBY).getMenuDao();
		CategoryDao categoryDao = DaoFactory.createDaoFactory(DaoFactory.DERBY).getCategoryDao();
		OrderDishesDao orderDishesDao = DaoFactory.createDaoFactory(DaoFactory.DERBY).getOrderDishesDao(); 
		UsersDao usersDao = DaoFactory.createDaoFactory(DaoFactory.DERBY).getUsersDao();
		OrdersDao ordersDao = DaoFactory.createDaoFactory(DaoFactory.DERBY).getOrdersDao();
		
		//Transaction wrapper initialize, initial context create
		TransactionWrapper transactionWrapper = new TransactionWrapper();
		
		//Services
		MenuService menuService = new MenuServiceImpl(menuDao, categoryDao, transactionWrapper);
		OrdersService ordersService = new OrdersServiceImpl(ordersDao, orderDishesDao, usersDao, transactionWrapper);
		OrderDishesService orderDishesService = new OrderDishesServiceImpl(orderDishesDao, transactionWrapper);
		UsersService usersService = new UsersServiceImpl(usersDao, transactionWrapper);
		
		servletContext.setAttribute("menuService", menuService);
		servletContext.setAttribute("ordersService", ordersService);
		servletContext.setAttribute("orderDishesService", orderDishesService);
		servletContext.setAttribute("usersService", usersService);
		
		logger.info("Context is initialized");
	}

}
