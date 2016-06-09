package com.credit.controller.command;

import com.credit.model.Model;
import com.credit.view.MenuView;

/**
 * Printing all bank list.
 * @author Tribel
 *
 */
public class BankListCommand extends MenuCommand{

	@Override
	public int execute(Model model, MenuView view) {
		view.printList(model.getBankList(), MenuView.BANK_LIST);
		return 1;
	}
	

}
