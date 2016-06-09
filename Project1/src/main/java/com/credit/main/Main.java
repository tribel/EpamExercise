package com.credit.main;

import com.credit.controller.Controller;
import com.credit.model.Model;
import com.credit.view.MenuView;

public class Main {
	
	public static void main(String[] args) {
		Controller controller = new Controller(new Model(), new MenuView());
		controller.processUser();
	}
}	
