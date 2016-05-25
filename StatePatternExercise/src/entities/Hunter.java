package entities;

public class Hunter implements State{

	@Override
	public void doSomething() {
		System.out.println("I am killing little rabbit");
	}

}
