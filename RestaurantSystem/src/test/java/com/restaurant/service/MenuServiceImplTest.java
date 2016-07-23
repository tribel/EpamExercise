package com.restaurant.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.restaurant.entity.Menu;
import com.restaurant.service.impl.MenuServiceImpl;

public class MenuServiceImplTest {

	private MenuService menuService = new MenuServiceImpl(null, null);
	
	@Test
	@Ignore
	public void testGetAllMenuList() {
		System.out.println(menuService.getAllMenuList());
	}

	@Test
	@Ignore
	public void testGetMenuListByName() {
		System.out.println(menuService.getMenuListByName("meat"));
	}

	@Test
	@Ignore
	public void testSaveDish() {
		Menu menu = new Menu(5.0, "chokolade pie", 3);
		menuService.saveDish(menu);
		assertTrue(menuService.getAllMenuList().contains(menu));
	}

	@Test
	public void test() {
		System.out.println(menuService.getById(32));
	}
}
