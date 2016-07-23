package com.restaurant.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.service.MenuService;
import com.restaurant.service.OrderDishesService;
import com.restaurant.service.OrdersService;
import com.restaurant.service.UsersService;
import com.restaurant.web.servlet.command.Command;
import com.restaurant.web.servlet.command.CommandFactory;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet
public class ControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 343505672851764353L;
	private static final Logger logger = LogManager.getLogger(ControllerServlet.class);
	public static final String ACTION = "action";
	
	private CommandFactory commandFactory;
	
	public static UsersService usersService;
	public static MenuService menuService;
	public static OrdersService ordersService;
	public static OrderDishesService odService;
	
	public ControllerServlet() {
		commandFactory = CommandFactory.getInstance();
	}
	
	@Override
	public void init() throws ServletException {
		logger.info("Services init");
		
		menuService = (MenuService) getServletContext()
				.getAttribute("menuService");
		
    	ordersService = (OrdersService) getServletContext()
    			.getAttribute("ordersService");
    	
    	usersService = (UsersService) getServletContext()
				.getAttribute("usersService");
    	
    	odService = (OrderDishesService) getServletContext().getAttribute(
				"orderDishesService");

    	if(usersService == null || ordersService == null || usersService == null ||
    			odService == null) {
    		
    		logger.error("Initialization error , empty services");
    	}
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter(ACTION);
		Command command = commandFactory.getCommand(action);
		request.getRequestDispatcher(command.executePost(request, response)).forward(request, response);
	}


}
