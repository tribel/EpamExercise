package com.restaurant.web.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.service.OrdersService;
import com.restaurant.web.servlet.ControllerServlet;

/**
 * Administrator  dish confirm opportunity.
 * @author Tribel
 *
 */
public class AdminConfirmCommand extends Command{
	
	private static final Logger logger = LogManager.getLogger(AdminConfirmCommand.class);
	
	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		OrdersService ordersService = ControllerServlet.ordersService;
		
		Integer orderId = Integer.valueOf(request.getParameter(ORDER_ID));
		ordersService.setStatusAsDone(orderId);
		logger.info("Confirm order "  + orderId);
		
		return CommandFactory.getInstance().getCommand(ADMIN_LIST).executePost(request, response);
	}
	
	
}
