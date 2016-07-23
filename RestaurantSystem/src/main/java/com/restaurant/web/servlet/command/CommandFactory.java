package com.restaurant.web.servlet.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory for command that initialized command
 * @author Tribel
 *
 */
public class CommandFactory {
	
	private static CommandFactory instance;
	
	private Map<String, Command> commandsMap;
	
	private CommandFactory() {
		commandsMap = new HashMap<>();
		commandsMap.put("login", new LoginCommand());
		commandsMap.put("registration", new RegistrationCommand());
		commandsMap.put("add", new AddToCartCommand());
		commandsMap.put("delete", new DeleteFromCartCommand());
		commandsMap.put("order", new CreateOrderCommand());
		commandsMap.put("confirm", new AdminConfirmCommand());
		commandsMap.put("pay", new PayCommand());
		commandsMap.put("logout", new LogOutCommand());
		commandsMap.put("menu", new MenuGetCommand());
		commandsMap.put("payList", new PayListGetCommand());
		commandsMap.put("adminList", new AdminGetConfirmList());
		
	}
	
	
	public static CommandFactory getInstance() {
		if(instance == null) instance = new CommandFactory();
		return instance;
	}
	
	public Command getCommand(String comm) {
		return commandsMap.get(comm);
	}
}
