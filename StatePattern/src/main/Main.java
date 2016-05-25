package main;

import human.Human;
import human.Work;
import radio.FirstRadio;
import radio.StationContext;

/**
 * Main class 
 * @author Tribel
 *
 */
public class Main {

	public static void main(String[] args) {
		StationContext stationContext = new StationContext();
		stationContext.setStation(new FirstRadio());
		stationContext.play();
		stationContext.nextStation();
		stationContext.play();
		
		Human human = new Human();
		human.setActivity(new Work());
		human.doSomething();
		human.doSomething();
		human.doSomething();
	}
}
