package com.credit.controller;

import java.util.Scanner;

import com.credit.view.MenuView;

/**
 * Class for validation data that user will be input.
 * @author Tribel
 *
 */
public class InputValidation {

	private MenuView view;
	
	/**
	 * @param view {@link MenuView} view class
	 */
	public InputValidation(MenuView view) {
		this.view = view;
	}
	
	/**
	 * Method that control simple integer values.
	 * @param sc {@link Scanner}
	 * @return {@link Integer} user input value. 
	 */
	public int inputIntValueWithScanner(Scanner sc) {
        while( ! sc.hasNextInt()) {
            view.printMessage(MenuView.ERROR_INPUT);
            sc.next();
        }
        return sc.nextInt();
    }
	
	/**
	 * Method that control index of array size.
	 * @param sc {@link Scanner}
	 * @param arraySize {@link Integer} array size.
	 * @return {@link Integer} user input value. return
	 */
	public int inputIntArrayValueWithScanner(Scanner sc, int arraySize) {
       do {
		while( ! sc.hasNextInt()) {
            view.printMessage(MenuView.ERROR_INPUT);
            sc.next();
		}
        
       }while(sc.nextInt() > (arraySize -1) || sc.nextInt() < 0) ;
        	
     
        return sc.nextInt();
    }
	
	/**
	 *  Method that control simple {@link String} values.
	 * @param sc {@link Scanner}
	 * @return {@link String} value.
	 */
	public String inputStringValueWithScanner(Scanner sc) {
		while( !sc.hasNextLine()) {
			view.printMessage(MenuView.ERROR_INPUT);
			sc.next();
		}
		return sc.nextLine();
	}
}
