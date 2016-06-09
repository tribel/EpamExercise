package com.credit.controller.command;

import com.credit.model.Model;
import com.credit.view.MenuView;

/**
 * For exiting form application.
 * @author Tribel
 *
 */
public class ExitCommand extends MenuCommand{

	@Override
	public int execute(Model model, MenuView view) {
		return -1;
	}

}
