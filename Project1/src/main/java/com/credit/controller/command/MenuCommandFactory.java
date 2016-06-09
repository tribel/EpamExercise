package com.credit.controller.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Command factory. 
 * @author Tribel
 *
 */
public class MenuCommandFactory {

	private static MenuCommandFactory instance;
	private Map<Integer, MenuCommand> commandMap;
	
	private MenuCommandFactory() {
		commandMap = new HashMap<>();
		commandMap.put(1, new BankListCommand());
		commandMap.put(2, new CreditList());
		commandMap.put(3, new FindCreditCommand());
		commandMap.put(4, new ExitCommand());
	}
	
	public static MenuCommandFactory getInstance() {
		if(instance == null) instance = new MenuCommandFactory();
		return instance;
	}
	
	public MenuCommand getCommand(Integer i) {
		return commandMap.get(i);
	}
}
