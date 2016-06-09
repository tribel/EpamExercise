package com.credit.view;

import java.util.List;

import com.credit.entity.Credit;


/**
 * View class.
 * @author Tribel
 *
 */
public class MenuView {
	
	public static final String HELLO_MSG = "Hello, you are in credit choise system!";
	public static final String FIRST_NAME = " Please entered your name";
	public static final String SECOND_NAME = "Please entered second name";
	public static final String SELECT_MENU_ITEM = "Select one menu item";
	public static final String SELECT_FIRST_STEP = "1. See Bank List \n"
								+ "2. See Credit List \n"
								+ "3. Find Credit \n"	
								+ "4. Exit";
	
	public static final String ENTERED_CREDIT_GOAL = "Please, enter goal of your credit";
	public static final String ENTERED_CREDIT_VALUE = "Entered value of credit, that you whant to get";
	public static final String EARLY_REPAYMENT_OPPORT = "Do you whant credit with early repayment opportunity (y/n)";
	public static final String LINE_UPPER_OPPORT = "Do you whant credit with line upper opportunity (y/n)";
	public static final String CHOOSE_CREDIT = "Choose credit that you whant to get(enter serial number)";
	public static final String EMPTY_LIST = "Your query returned no results";
	public static final String ERROR_INPUT = "Wrong input! Repeat please!";
	public static final String CREDIT_LIST = "Credits list:";
	public static final String BANK_LIST = "Bank list";
	public static final String YOU_CHOISE = "Great! the choice is made";
	
	/**
	 * Printing simple message
	 * @param message {@link String} 
	 */
	public void printMessage(String message){
        System.out.println(message);
    }
	
	
	/**
	 * Printing needed list.
	 * @param list {@link List} of some objects.
	 * @param str {@link String} message that will be printed on screen.
	 */
	public void printList(List<?> list, String str) {
		System.out.println(str);
		list.stream().forEach(System.out::println);
	}
								  
	/**
	 * Printing credit.
	 * @param credit {@link Credit} that will be printed.
	 * @param str {@link String} simple message.
	 */
	public void printCredit(Credit credit, String str) {
		System.out.println(str);
		System.out.println(credit);
	}
}
