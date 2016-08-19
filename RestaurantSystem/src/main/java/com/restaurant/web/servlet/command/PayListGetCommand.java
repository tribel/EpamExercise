package com.restaurant.web.servlet.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restaurant.entity.Orders;
import com.restaurant.entity.Users;
import com.restaurant.service.OrderDishesService;
import com.restaurant.service.OrdersService;
import com.restaurant.web.beans.AdminBean;
import com.restaurant.web.servlet.ControllerServlet;

/**
 * Returning list pay list by exact user.
 * @author Tribel
 *
 */
public class PayListGetCommand extends Command{

	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		OrdersService ordersService = ControllerServlet.ordersService;
		OrderDishesService odService = ControllerServlet.odService;
		
		HttpSession httpSession = request.getSession();
		Users user = (Users) httpSession.getAttribute(Command.USER_ATR);

		List<AdminBean> payBeans = new ArrayList<>();
		for (Orders o : ordersService.getDoneOrdersList(user.getId())) {
			payBeans.add(new AdminBean(o.getId(), o.getDateTime(), odService
					.getTotalOrderPrice(o.getId())));
		}

		request.setAttribute(Command.PAY_LIST_ATR, payBeans);
		return PAY_PAGE;
	}

}
