package human;

/**
 * 
 * @author Tribel
 *
 */
public class Human {
	
	private Activity activity;
	
	public void doSomething(){
        activity.doSomething(this);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
