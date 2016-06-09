package com.credit.controller.command;

import com.credit.model.Model;
import com.credit.view.MenuView;

/**
 * Command pattern. abstract class.
 * @author Tribel
 *
 */
public abstract class MenuCommand {

	public MenuCommand() {
	}

	public abstract int execute(Model model, MenuView view);
}
