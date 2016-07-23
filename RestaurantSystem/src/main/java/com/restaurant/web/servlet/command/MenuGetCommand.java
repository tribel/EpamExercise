package com.restaurant.web.servlet.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.restaurant.entity.Menu;
import com.restaurant.service.MenuService;
import com.restaurant.web.servlet.ControllerServlet;

/**
 * Returning menu page 
 * @author Tribel
 *
 */
public class MenuGetCommand extends Command{

	private static final Logger logger = LogManager.getLogger(MenuGetCommand.class);
	
	@Override
	public String executePost(HttpServletRequest request, HttpServletResponse response) {
		MenuService menuService = ControllerServlet.menuService;
		
		List<Menu> menuList = null;
    	List<String> categoryList = menuService.getAllCategoryList();
    	categoryList.add(0, "choose");	
    	request.setAttribute(Command.CATEGORY_LIST_ATR, categoryList);
    	String category = request.getParameter(Command.CATEGORY_ATR);
		logger.info(category + "  category chose.");
    	
    	if(category == null || category.equals("") || category.equals("choose")) {
    		menuList = menuService.getAllMenuList();
    	} else {
    		menuList = menuService.getMenuListByName(category);
    	}
  
		request.setAttribute(Command.MENU_LIST_ATR, menuList);	
		return MENU_PAGE;
	}

}
