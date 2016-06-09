package com.credit.controller;

import java.util.Scanner;

import com.credit.controller.command.MenuCommandFactory;
import com.credit.model.Model;
import com.credit.view.MenuView;

/**
 * Controller of application.
 * @author Tribel
 *
 */
public class Controller {
	
	private Model model;
	private MenuView view;
	private MenuCommandFactory commandFactory;
	private InputValidation input;
	
	
	public Controller(Model model, MenuView view) {
		this.model = model;
		this.view = view;
		input = new InputValidation(view);
	}
	
	/**
	 * Method that starts the console application.
	 */
	public void processUser() {
		Scanner scanner = new Scanner(System.in);
		commandFactory = MenuCommandFactory.getInstance();
		
		view.printMessage(MenuView.HELLO_MSG);
		int resultValue = 0;
		while(resultValue != -1) {	
			view.printMessage(MenuView.SELECT_MENU_ITEM);
			view.printMessage(MenuView.SELECT_FIRST_STEP);
			resultValue = commandFactory.getCommand(input.inputIntValueWithScanner(scanner)).execute(model, view);
		}
	}
	
	
	
}
