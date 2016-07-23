package com.restaurant.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.entity.Users;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */

//@WebFilter
public class AuthenticationFilter implements Filter {

	private static final Logger logger = LogManager.getLogger(AuthenticationFilter.class);

	private static final String LOGIN = "login";
	private static final String USER_ATTRIBUTE = "user";
	private String REGISTRATION_PAGE;
	private String LOGIN_PAGE;

	public AuthenticationFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		logger.info("AuthenticationFilter destroyed.");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		Users sessionUser = (Users) req.getSession().getAttribute(USER_ATTRIBUTE);
		logger.info("Session user"+ sessionUser);
		
		if ( (req.getRequestURL().toString().contains(LOGIN_PAGE))
				|| (req.getRequestURL().toString().contains(REGISTRATION_PAGE))) {
			
			logger.info("Success redirect");
			chain.doFilter(request, response);
			
		}else if(sessionUser != null && sessionUser.getId() != 0){
			logger.info("Success redirect");
			chain.doFilter(request, response);
		} else {
			logger.info("No user logged in " + req.getRequestURI());
			 chain.doFilter(request, response);
			//res.sendRedirect(LOGIN);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.REGISTRATION_PAGE = fConfig.getInitParameter("registrationPage");
		this.LOGIN_PAGE = fConfig.getInitParameter("loginPage");
		logger.info("AuthenticationFilter initialized.");
	}

}
