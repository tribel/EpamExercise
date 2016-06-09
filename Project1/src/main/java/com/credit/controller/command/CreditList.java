package com.credit.controller.command;

import com.credit.model.Model;
import com.credit.view.MenuView;

/**
 * Printing all credits list, from all banks.
 * @author Tribel
 *
 */
public class CreditList extends MenuCommand{

	@Override
	public int execute(Model model, MenuView view) {
		view.printList(model.getAllCreditList(), MenuView.CREDIT_LIST);	
		return 1;
	}

}
