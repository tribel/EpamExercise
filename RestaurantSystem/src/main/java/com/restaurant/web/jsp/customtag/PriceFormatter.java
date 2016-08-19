package com.restaurant.web.jsp.customtag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class represents custom tag for creating
 * currency displaying.
 * @author Tribel
 *
 */
public class PriceFormatter extends SimpleTagSupport{
	
	private static final Logger logger = LogManager.getLogger(PriceFormatter.class);
	private static final String UAH_FRMT = "uah";
	private String price;
	
	
	public PriceFormatter() {
	}

	@Override
	public void doTag() throws JspException, IOException {
		logger.info("Formatt price");
		try {
			String formattedPrice = price + UAH_FRMT;
			getJspContext().getOut().write(formattedPrice);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new SkipPageException("Exception in formatting" + price);
		}
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


}
