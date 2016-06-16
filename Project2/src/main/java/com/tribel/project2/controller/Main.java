package com.tribel.project2.controller;

import com.tribel.project2.model.Parse;
import com.tribel.project2.view.View;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller(new View(), new Parse());
		controller.processUser("input.txt");
		
	}
}
