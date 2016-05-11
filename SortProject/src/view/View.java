package view;

public class View {
	
	public static final String INITIAL_ARRAY = "Initial array is:";
	public static final String OUTPUT_MESSAGE = "Sorted array: ";
	public static final String BUBBLE_SORT = "Bubble sort:"; 
	public static final String INSERTION_SORT = "Insertion sort:";
	public static final String SELECTION_SORT = "Selection sort:";
	
    public void printMessage(String message){
        System.out.println(message);
    }

    public void printArray(int[] array) {
    	for(int i: array) {
    		System.out.print(i + " ");
    	}
        System.out.println();
    }
}
