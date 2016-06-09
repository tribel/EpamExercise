package com.credit.controller.command;

import java.util.List;
import java.util.Scanner;

import com.credit.controller.InputValidation;
import com.credit.entity.Credit;
import com.credit.model.Model;
import com.credit.view.MenuView;

/**
 * Creating filter data and find needed credits , 
 * that will be meet requirements of user.
 * @author Tribel
 *
 */
public class FindCreditCommand extends MenuCommand{
	
	private Scanner scanner = new Scanner(System.in);
	
	@Override
	public int execute(Model model, MenuView view) {
		InputValidation input = new InputValidation(view);
		boolean earlyRepayment = false;
		boolean lineUpper = false;
		
		view.printMessage(MenuView.ENTERED_CREDIT_GOAL);
		String creditGoal = input.inputStringValueWithScanner(scanner);
		
		view.printMessage(MenuView.EARLY_REPAYMENT_OPPORT);
		if(input.inputStringValueWithScanner(scanner).equalsIgnoreCase("y")) {
			earlyRepayment = true;
		}
		
		view.printMessage(MenuView.LINE_UPPER_OPPORT);
		if(input.inputStringValueWithScanner(scanner).equalsIgnoreCase("y")) {
			lineUpper = true;
		}
		
		List<Credit> resultList = model.findCreditByFilter(creditGoal, earlyRepayment, lineUpper);
		if(resultList.isEmpty()) {
			view.printMessage(MenuView.EMPTY_LIST);
		} else {
			view.printList(resultList, MenuView.CREDIT_LIST);
			view.printMessage(MenuView.CHOOSE_CREDIT);
			int index = input.inputIntValueWithScanner(scanner);
			Credit finalCredit = resultList.get(index -1);
			view.printCredit(finalCredit, MenuView.CHOOSE_CREDIT);
			view.printMessage(MenuView.YOU_CHOISE);
		}
		
		return 1;
	}

}
