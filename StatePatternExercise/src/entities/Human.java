package entities;

public class Human {

	private State state;
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void nextState(String str) {
		switch (str) {
        case "Fish":
            setState(new Fisher());
            break;

        case "Animal":
            setState(new Hunter());
            break;

        case "Mushroom":
            setState(new MushroomGuy());
            break;
    }

    state.doSomething();

	}
}
