package com.restaurant.web.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.service.OrdersService;
import com.restaurant.web.servlet.ControllerServlet;

/**
 * Pay for order by the concrete user.
 * @author Tribel
 *
 */
public class PayCommand extends Command{

	private static final Logger logger = LogManager.getLogger(PayCommand.class);
	
	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		OrdersService ordersService = ControllerServlet.ordersService;
		
		Integer orderId = Integer.valueOf(request.getParameter(ORDER_ID));
		ordersService.setStatusAsPaid(orderId);
		
		logger.info("Order " + orderId + "is paid");
		return CommandFactory.getInstance().getCommand(PAY_LIST).executePost(request, response);
	}
	
}
