package View;

import java.util.List;

import entity.Notebook;

/**
 * Class for output data to screen
 * @author Tribel
 *
 */
public class View {
	
	public static final String HELLO_MESSAGE = "Hello!";
	public static final String MAIN_MENU = "Menu:\n1. Create note\n2. Show all notes\n3. Exit";
	public static final String INPUT_DATA = "Input ";
	public static final String INDEX = "Index";
	public static final String CITY = "City";
	public static final String STREET = "Street";
	public static final String HOUSE = "House number";
	public static final String FLAT_NUMBER = "Flat";
	public static final String NAME = "Name";
    public static final String SURNAME = "Surname";
    public static final String PATRONYMIC = "Patronymic";
    public static final String NICKNAME = "Nickname";
    public static final String COMMENTARY = "Commentary";
    public static final String GROUP = "Group";
    public static final String HOME_NUMBER = "Phone number";
    public static final String MOBILE_PHONE_NUMBER = "Cellphone number";
    public static final String EMAIL = "email";
    public static final String SKYPE = "skype";
    public static final String ADRESS = "Adress";
    public static final String CREATING_DATE = "Introduction date";
    public static final String LAST_CHANGE_DATE = "Last change date";
    public static final String WRONG_INPUT_DATA = "Wrong input data,  repeat ! ";
    public static final String NOTE_BOOK_LIST = "All address list ";
    
    /**
     * Printing simple message
     * @param msg {@link String} message
     */
    public void printMessage(String msg) {
    	System.out.println(msg);
    }
    
    /**
     * Printing few messages 
     * @param msg array {@link String} messages
     */
    public void printMessages(String... msg) {
    	for(String str: msg) {
    		System.out.print(str);
    	}
    }
    
    /**
     * Printing existing Notebook list
     * @param list {@link List} {@link Notebook}
     */
    public void printList(List<Notebook> list) {
    	System.out.println(NOTE_BOOK_LIST);
    	list.stream().forEach(System.out::println);
    }
}
