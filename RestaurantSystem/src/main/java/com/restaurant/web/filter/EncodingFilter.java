package com.restaurant.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet Filter implementation class EncodingFilter.
 * It sets single encoding type for application.
 */
public class EncodingFilter implements Filter {

	private static final Logger logger = LogManager.getLogger(EncodingFilter.class);
	private static final String UTF_8 = "UTF-8";
	
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() {
    	logger.info("EncodingFilter destroyed.");
    }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(UTF_8);
		response.setCharacterEncoding(UTF_8);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		logger.info("EncodingFilter initialized. ");
	}

}
