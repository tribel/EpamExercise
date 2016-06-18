package com.tribel.project2.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.tribel.project2.entity.Text;
import com.tribel.project2.model.Parse;
import com.tribel.project2.view.View;

/**
 * Controller of application , start the program and output parsed text to
 * screen.
 * 
 * @author Tribel
 *
 */
public class Controller {

	private View view;
	private Parse parse;

	/**
	 * Controller constructor
	 * 
	 * @param view define view part
	 * @param parse define model part
	 */
	public Controller(View view, Parse parse) {
		this.view = view;
		this.parse = parse;
	}

	
	/**
	 * Method that start the application , parse text and
	 * output it to the screen.
	 * @param fileName path of the input file.
	 */
	public void processUser(String fileName) {
		String fullText = null;
		try {
			fullText = new String(Files.readAllBytes(Paths.get(fileName)),
										StandardCharsets.UTF_8);
		} catch (IOException e) {
			view.printMessage(e.getMessage());
		}
		
		view.printMessage(View.FIRST_MSG);
		Text text = new Text(fullText);
		parse.putAnalizeText(text);
		parse.sortByWordCount(text).stream().forEach(s -> view.printMessage(s));

	}

}
