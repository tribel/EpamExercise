package controller;

import java.util.Random;

import model.SortAbstract;
import view.View;

public class Controller {
	
	public static final Integer ARRAY_LENGTH = 10;
	public static final Integer RANDOM_INTERVAL = 99;
	
	private View view;
	private SortAbstract sortModel;
	
	public Controller(View view, SortAbstract sortModel) {
		this.view = view;
		this.sortModel = sortModel;
	}
	
	public void processUser() {
		int[] array = randomArrayFilling();
		
		view.printMessage(View.INITIAL_ARRAY);
		view.printArray(array);
		sortModel.setArray(array);
		view.printMessage(View.OUTPUT_MESSAGE);
		view.printArray(sortModel.sort());
		
	}
	
	protected int[] randomArrayFilling() {
		Random random = new Random();
		int[] array = new int[ARRAY_LENGTH];
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(RANDOM_INTERVAL);
		}
		
		return array;
	}
}
