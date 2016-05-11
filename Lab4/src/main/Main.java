package main;

import controller.Controller;
import View.View;
import model.NoteModel;

/**
 * Main class 
 * @author Tribel
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		NoteModel noteModel = new NoteModel();
		View view = new View();
		Controller controller = new Controller(noteModel, view);
		
		controller.processUser();
	}
}
