package main;

import entities.Human;

public class Main {

	public static void main(String[] args) {
		Human human = new Human();
        human.nextState("Mushroom");
        human.nextState("Animal");
        human.nextState("Fish");
	}
}
