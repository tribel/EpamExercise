package com.restaurant.web.servlet.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.entity.Orders;
import com.restaurant.service.OrderDishesService;
import com.restaurant.service.OrdersService;
import com.restaurant.service.UsersService;
import com.restaurant.web.beans.AdminBean;
import com.restaurant.web.servlet.ControllerServlet;

public class AdminGetHistory extends Command{

	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		OrdersService ordersService = ControllerServlet.ordersService;
		
		List<AdminBean> list = new ArrayList<>();
		
		for(Orders o: ordersService.getHistory()) {
			list.add(fillAdminBean(o));
		}
		request.setAttribute(Command.HISTORY_ATR, list);
		return HISTORY_PAGE;
	}
	
	protected AdminBean fillAdminBean(Orders order) {
		UsersService usersService = ControllerServlet.usersService;
		OrderDishesService odService = ControllerServlet.odService;
		
		AdminBean bean = new AdminBean();
			bean.setOrderId(order.getId());
			bean.setDateTime(order.getDateTime());
			bean.setUser(usersService.getUserById(order.getUserId()));
			bean.setTotalSum(odService.getTotalOrderPrice(order.getId()));
			bean.setCount(odService.getMenuListByOrderID(order.getId()));
		return bean;
	}

}
