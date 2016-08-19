package com.restaurant.web.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.service.OrdersService;
import com.restaurant.web.servlet.ControllerServlet;

/**
 * Denial some order by administrator.
 * @author Tribel
 *
 */
public class AdminDenialCommand extends Command{

	private static final Logger logger = LogManager.getLogger(AdminDenialCommand.class);
	
	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		OrdersService ordersService = ControllerServlet.ordersService;
		
		int orderId = Integer.valueOf(request.getParameter(ORDER_ID));
		ordersService.setStatusAsDenial(orderId);
		logger.info("Denial the order " + orderId);
		
		return CommandFactory.getInstance().getCommand(ADMIN_LIST).executePost(request, response);
	}

}
