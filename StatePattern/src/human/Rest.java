package human;

public class Rest implements Activity {

	@Override
	public void doSomething(Human context) {
		for (int i = 0; i < 3; i++)
			System.out.println("Resting...");
		context.setActivity(new Work());
	}
}
