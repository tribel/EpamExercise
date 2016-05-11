package controller;

import java.time.LocalDate;
import java.util.Scanner;

import entity.Address;
import entity.Group;
import entity.Notebook;
import View.View;
import model.NoteModel;

/**
 * Controller class 
 * @author Tribel
 *
 */
public class Controller implements RegexConstant{
	
	private NoteModel notebook;
	private View view;
	
	public Controller(NoteModel notebook, View view) {
		this.notebook = notebook;
		this.view = view;
	}
	
	/**
	 * run method 
	 */
	public void processUser() {
		Scanner scanner = new Scanner(System.in);
		view.printMessage(View.HELLO_MESSAGE);
		
		while(true) {
			view.printMessage(View.MAIN_MENU);
			int menuChoise = inputIntValue(scanner);
			switch(menuChoise) {
				case 1:
					notebook.addNotebook(readNotebook(scanner));
					break;
				case 2:
					view.printList(notebook.getNotebooks());
					break;
				case 3:
					return;
				default: 
					view.printMessage(View.WRONG_INPUT_DATA);
					break;
			}
			
		}
		
	}
	
	/**
	 * Read notebook data 
	 * @param sc {@link Scanner} entity
	 * @return created {@link Notebook} entity. 
	 */
	protected Notebook readNotebook(Scanner sc) {
		Notebook tmpNotebook = new Notebook();
		tmpNotebook.setSurname(inputStringWithPattern(sc, MIDDLE_NAME, View.SURNAME));
		tmpNotebook.setName(inputStringWithPattern(sc, FIRST_NAME, View.NAME));
		tmpNotebook.setPatronymic(inputStringWithPattern(sc, LAST_NAME, View.PATRONYMIC));
		tmpNotebook.setNickname(inputStringWithPattern(sc, NICK_NAME, View.NICKNAME));
		tmpNotebook.setComment(inputStringWithPattern(sc, COMMENT, View.COMMENTARY, true));
		tmpNotebook.setGroup(inputGroup(sc));
		tmpNotebook.setHomeTelephone(inputStringWithPattern(sc, HOME_PHONE, View.HOME_NUMBER));
		tmpNotebook.setMobileTelephone(inputStringWithPattern(sc, MOBILE_PHONE, View.MOBILE_PHONE_NUMBER));
		tmpNotebook.setEmail(inputStringWithPattern(sc, EMAIL, View.EMAIL));
		tmpNotebook.setSkype(inputStringWithPattern(sc, SKYPE, View.SKYPE));
		view.printMessage(View.ADRESS);
		tmpNotebook.setAddress(inputAddress(sc));
		tmpNotebook.setCreateDate(LocalDate.now());
		
		return tmpNotebook;
	}
	
	/**
	 * Read address data
	 * @param sc {@link Scanner} entity
	 * @return creadet {@link Address} entity
	 */
	protected Address inputAddress(Scanner sc) {
		Address tmpAddress = new Address();
		tmpAddress.setIndex(inputStringWithPattern(sc, INDEX, View.INDEX));
		tmpAddress.setCity(inputStringWithPattern(sc, CITY, View.CITY));
		tmpAddress.setStreet(inputStringWithPattern(sc, STREET, View.STREET));
		tmpAddress.setHouseNumber(inputStringWithPattern(sc, BUILDING, View.HOUSE));
		tmpAddress.setFlatNumber(inputStringWithPattern(sc, FLAT, View.FLAT_NUMBER));
		return tmpAddress;
		
	}
	
	
	/**
     * Read text line from console satisfying pattern
     *
     * @param sc   {@link Scanner} entity
     * @param pattern regular expression
     * @param field   name of field
     * @param empty   indicates whether the field be empty
     * @return {@link String} text
     */
	private String inputStringWithPattern(Scanner sc, String pattern, String field, boolean empty) {
		if (!empty) return inputStringWithPattern(sc, pattern, field);
		
		String line;
		while (true) {
			view.printMessage(field);
			if (sc.hasNextLine()) {
				line = sc.nextLine();
				if (line.matches(pattern)) {
					return line;
				} else {
					view.printMessage(View.WRONG_INPUT_DATA);
				}
			} else {
				return "";
			}
		}
	}

	
	/**
     * Read text line from console satisfying pattern
     *
     * @param sc   {@link Scanner} entity
     * @param pattern regular expression
     * @param field   name of field
     * @return {@link String} text
     */
	private String inputStringWithPattern(Scanner sc, String pattern, String field) {
		String line;
		while (true) {
			view.printMessage(field);
			line = sc.nextLine();
			if (line.matches(pattern))
				return line;
			else {
				view.printMessage(View.WRONG_INPUT_DATA);
			}
		}
	}
	
	/**
	 * Read group from scanner
	 * @param sc {@link Scanner} entity
	 * @return {@link Group} id value
	 */
	private Group inputGroup(Scanner sc) {
		Group[] groups = Group.values();
		view.printMessage(View.GROUP);

		for (int i = 0; i < groups.length; i++) {
			view.printMessage(groups[i].name());
		}
		int groupId = 0;

		while (true) {
			if (!sc.hasNextInt()) {
				view.printMessage(View.WRONG_INPUT_DATA);
				sc.next();
			} else {
				groupId = sc.nextInt();
				sc.nextLine();
			}
			return groups[groupId];
		}
	}
	
	 private int inputIntValue(Scanner sc) {
	        while (true) {
	            if (!sc.hasNextInt()) {
	                view.printMessage(View.WRONG_INPUT_DATA);
	                sc.next();
	            } else {
	                int num = sc.nextInt();
	                sc.nextLine();
	                return num;
	            }
	        }
	    }
	
}
