package com.restaurant.web.servlet.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.entity.Menu;
import com.restaurant.entity.OrderDishes;
import com.restaurant.entity.Orders;
import com.restaurant.entity.Users;
import com.restaurant.service.OrdersService;
import com.restaurant.web.beans.CartBean;
import com.restaurant.web.servlet.ControllerServlet;

/**
 * Command for creation order by the user
 * @author Tribel
 *
 */
public class CreateOrderCommand extends Command{
	
	private static final Logger logger = LogManager.getLogger(CreateOrderCommand.class);
	
	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		OrdersService ordersService = ControllerServlet.ordersService;
		
		logger.info("Create order");
		HttpSession httpSession  = request.getSession();
    	CartBean cartBean = (CartBean)httpSession.getAttribute(CART_ATR);
    	Users user = (Users)httpSession.getAttribute(USER_ATR);
  
    	List<OrderDishes> orderDishesList = new ArrayList<>();
    	for(Menu d: cartBean.getAllCartItems()) {
    		orderDishesList.add(new OrderDishes(d.getId(), d.getPrice()));
    	}
    	
    	ordersService.createOrder(new Orders(), user, orderDishesList);
    	cartBean.clearAllList();
    	httpSession.setAttribute(CART_ATR, cartBean);
		return AFTER_ORDER_PAGE;
	}
	
}
