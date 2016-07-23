package com.restaurant.web.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.entity.Users;
import com.restaurant.service.UsersService;
import com.restaurant.web.servlet.ControllerServlet;

/**
 * Registration new user to the system
 * @author Tribel
 *
 */
public class RegistrationCommand extends Command {

	private static final Logger logger = LogManager.getLogger(RegistrationCommand.class);
	
	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		UsersService usersService = ControllerServlet.usersService;
		
		String name = request.getParameter(NAME_ATR);
		String email = request.getParameter(EMAIL_ATR);
		String address = request.getParameter(ADDRESS_ATR);
		String login = request.getParameter(LOGIN_ATR);
		String password = request.getParameter(PSW_ATR);
		String repeatPassword = request.getParameter(REPEAT_PSW_ATR);
		
		if (name.isEmpty() || email.isEmpty() || address.isEmpty() || login.isEmpty()
				|| password.isEmpty() || !password.equals(repeatPassword)) {

			logger.info("Wrong input data");
			return REGISTRATION_PAGE;
		}
		
		usersService.registration(new Users(name, email, address, login, password));
		return LOGIN_PAGE;
	}

}
