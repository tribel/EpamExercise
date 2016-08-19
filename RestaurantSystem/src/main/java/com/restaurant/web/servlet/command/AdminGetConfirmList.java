package com.restaurant.web.servlet.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.entity.Orders;
import com.restaurant.service.OrderDishesService;
import com.restaurant.service.OrdersService;
import com.restaurant.service.UsersService;
import com.restaurant.web.beans.AdminBean;
import com.restaurant.web.servlet.ControllerServlet;

/**
 * Returning and shows menu confirm list for administrator.
 * @see {@link AdminBean}
 * @author Tribel
 *
 */
public class AdminGetConfirmList extends Command{

	private static final Logger logger = LogManager.getLogger(AdminGetConfirmList.class);
	
	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		OrdersService ordersService = ControllerServlet.ordersService;
		
		logger.info("Filling admin page");
		List<AdminBean> beansList = new ArrayList<>();
		for(Orders o: ordersService.getOrdersList()) {
			beansList.add(fillAdminBean(o));
		}
		request.setAttribute(Command.ORDERS_ATR, beansList);
		return ADMIN_PAGE;
	}
	
	protected AdminBean fillAdminBean(Orders order) {
		UsersService usersService = ControllerServlet.usersService;
		OrderDishesService odService = ControllerServlet.odService;
		
		AdminBean bean = new AdminBean();
			bean.setOrderId(order.getId());
			bean.setDateTime(order.getDateTime());
			bean.setUser(usersService.getUserById(order.getUserId()));
			bean.setTotalSum(odService.getTotalOrderPrice(order.getId()));
		return bean;
	}

}
