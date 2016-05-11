package model;

public class InsertionSort extends SortAbstract{

	@Override
	public int[] sort() {
		
		for(int i = 1; i < array.length; i++) {
			int j = i;
			while(j > 0 && array[j] < array[j -1]) {
				swap(j, j -1);
				j--;
			}
		}
		return array;
	}
	
	
}
