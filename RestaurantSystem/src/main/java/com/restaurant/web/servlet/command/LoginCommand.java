package com.restaurant.web.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.entity.Users;
import com.restaurant.service.UsersService;
import com.restaurant.web.servlet.ControllerServlet;

/**
 *  User authorization that already exist .
 * @author Tribel
 *
 */
public class LoginCommand extends Command{
	
	private static final Logger logger = LogManager.getLogger(LoginCommand.class);

	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		UsersService usersService = ControllerServlet.usersService;
		
		String login = request.getParameter(LOGIN_ATR);
		String password = request.getParameter(PSW_ATR);
		
		HttpSession session = request.getSession();
		if(login == null || password == null || login.isEmpty() || password.isEmpty()) {
			logger.info("Wrong input data");
			return LOGIN_PAGE;
		}

		Users user = usersService.authorize(login, password);
		if(user == null) {
			logger.info("No such user in data base. Login failed.");
			return LOGIN_PAGE;
		}
		
		session.setAttribute(USER_ATR, user);
		session.setAttribute(ROLE_ATR, usersService.getRoleNameById(user.getRoleId()));
		
		return CommandFactory.getInstance().getCommand(MENU_PAGE).executePost(request, response);
	}

	

	
}
