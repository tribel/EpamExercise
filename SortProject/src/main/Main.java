package main;

import view.View;
import controller.Controller;
import model.BubbleSort;
import model.InsertionSort;
import model.SelectionSort;

public class Main {

		public static void main(String[] args) {
			BubbleSort bubbleSort = new BubbleSort();
			InsertionSort insertionSort = new InsertionSort();
			SelectionSort selectionSort = new SelectionSort();
			
			//choose sort method
			Controller controller = new Controller(new View(), insertionSort);
			controller.processUser();
		}
}
