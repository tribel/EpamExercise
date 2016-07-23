package com.restaurant.web.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.service.MenuService;
import com.restaurant.web.beans.CartBean;
import com.restaurant.web.servlet.ControllerServlet;

/**
 * Add selected dish to menu cart
 * @author Tribel
 *
 */
public class AddToCartCommand extends Command {

	private static final Logger logger = LogManager.getLogger(AddToCartCommand.class);

	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		MenuService menuService =  ControllerServlet.menuService;
		
		logger.info("Add dish to cart");
		HttpSession httpSession = request.getSession();
		Integer dishId = Integer.valueOf(request.getParameter(ID_DISH_ATR));
		CartBean cartBean = (CartBean)httpSession.getAttribute(CART_ATR);
		
		if(cartBean == null) {
			cartBean = new CartBean();	
		}
		
		cartBean.addCartItem(menuService.getById(dishId));
		httpSession.setAttribute(CART_ATR, cartBean);
		return CommandFactory.getInstance().getCommand(MENU_PAGE).executePost(request, response);
	}

}
