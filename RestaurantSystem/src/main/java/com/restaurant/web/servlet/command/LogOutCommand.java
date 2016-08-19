package com.restaurant.web.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Out from the current session by current user.
 * @author Tribel
 *
 */
public class LogOutCommand extends Command{

	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session != null){
            session.invalidate();
        }
        
		return LOGIN_PAGE;
	}

}
