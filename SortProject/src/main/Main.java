package main;

import view.View;
import controller.Controller;
import model.BubbleSort;
import model.InsertionSort;
import model.MergeSort;
import model.SelectionSort;

public class Main {

		public static void main(String[] args) {
			BubbleSort bubbleSort = new BubbleSort();
			InsertionSort insertionSort = new InsertionSort();
			SelectionSort selectionSort = new SelectionSort();
			MergeSort mergeSort = new MergeSort();
			
			//choose sort method
			Controller controller = new Controller(new View(), mergeSort);
			controller.processUser();
		}
}
