package com.tribel.project2.view;

import java.util.List;

import com.tribel.project2.entity.Sentence;

/**
 * View class that represent data to screen.
 * @author Tribel
 *
 */
public class View {

	public static final String FIRST_MSG = "Reperesentation input text by sentences word count.";

	/**
	 * Print message.
	 * @param str {@link String} message that will be printed.
	 */
	public void printMessage(String str) {
		System.out.println(str);
	}
	
	/**
	 * Print entire sentence.
	 * @param list {@link Sentence} {@link List} that will be output.
	 */
	public void printMessage(Sentence list) {
		System.out.println(list.getList());
	}
}
