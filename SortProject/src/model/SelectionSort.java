package model;

public class SelectionSort extends SortAbstract{

	public SelectionSort() {
		super();
	}
	
	@Override
	public int[] sort() {
		
		for(int i = 0; i < array.length - 1; i++) {
			int index = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[index] > array[j]) {
					index = j;
				}
				
				if(index != i) swap(index, i);
			}
		}
		return array;
	}

		
}
