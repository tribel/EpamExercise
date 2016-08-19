package com.restaurant.web.servlet.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Abstract command class 
 * @author Tribel
 *
 */
public abstract class Command{
	/* 
	 *  Admin Servlet
	 */
	public static final String ADMIN_ACTION = "admAction";
	public static final String ORDER_ID = "orderId";
	public static final String CONFIRM = "confirm";
	public static final String DENIAL = "denial";
	public static final String ORDERS_ATR = "orders";

	public static final String ADMIN_PAGE = "adminPage";
	public static final String HISTORY_PAGE = "history";
	public static final String ADMIN_SERVLET = "AdminServlet";
	public static final String LOGIN_PAGE = "login";
	public static final String MENU_PAGE = "menu";
	public static final String PAY_PAGE = "payPage";
	public static final String PAY_SERVLET = "PayServlet";
	public static final String REGISTRATION_PAGE = "registration";
	public static final String PAY_LIST = "payList";
	public static final String ADMIN_LIST = "adminList";
	/*
	 * Cart Servlet
	 */
	public static final String ACTION = "action";
	public static final String ADD_ATR = "add";
	public static final String DELETE_ATR = "delete";
	public static final String CART_PAGE = "cart";
	public static final String ORDER_ACTION = "order";
	public static final String AFTER_ORDER_PAGE = "afterOrder";
	public static final String CART_ATR = "cart";
	public static final String USER_ATR = "user";
	public static final String ID_DISH_ATR = "idDish";
	public static final String ID_DISH_DEL_ATR = "idDishDel";
	
	/*
	 * Menu Servlet
	 */
	public static final String MENU_SERVLET = "MenuServlet";
	public static final String CATEGORY_ATR = "category";
	public static final String MENU_LIST_ATR = "menuList";
	public static final String CATEGORY_LIST_ATR = "categoryList";
	/*
	 * Login
	 */
	public static final String LOGIN_ATR = "login";
	public static final String PSW_ATR = "password";
	public static final String ROLE_ATR = "role";
	public static final String NAME_ATR = "name";
	public static final String EMAIL_ATR = "email";
	public static final String REPEAT_PSW_ATR = "repeatPassword";
	public static final String ADDRESS_ATR = "address";
	public static final String HISTORY_ATR = "history";
	
	/*
	 * Pay
	 */
	public static final String PAY_LIST_ATR = "payList";

	
	public Command() {
	}
	
	public abstract String executePost(HttpServletRequest request, HttpServletResponse response);
}
