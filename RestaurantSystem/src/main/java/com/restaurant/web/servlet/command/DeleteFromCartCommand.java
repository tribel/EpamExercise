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
 * Deleting menu dish form the cart by the user.
 * @author Tribel
 *
 */
public class DeleteFromCartCommand extends Command{

	private static final Logger logger = LogManager.getLogger(DeleteFromCartCommand.class);
	
	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		MenuService menuService =  ControllerServlet.menuService;
		
		logger.info("Delete dish from cart");
		HttpSession httpSession = request.getSession();
		Integer dishId = Integer.valueOf(request.getParameter(ID_DISH_DEL_ATR));
		CartBean cartBean = (CartBean)httpSession.getAttribute(CART_ATR);
		cartBean.deleteCartItem(menuService.getById(dishId));
		httpSession.setAttribute(CART_ATR, cartBean);
		return CART_PAGE;
	}

	
}	
