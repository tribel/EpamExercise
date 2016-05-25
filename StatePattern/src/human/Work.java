package human;

public class Work implements Activity {
    
	@Override
    public void doSomething(Human context) {
        System.out.println("Working...");
        context.setActivity(new Rest());
    }
	
}