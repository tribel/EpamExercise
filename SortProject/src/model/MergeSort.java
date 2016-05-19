package model;

public class MergeSort extends SortAbstract {

	private int[] helper;
 	
	@Override
	public int[] sort() {
		helper = new int[array.length];
		mergeSort(0	, array.length - 1);
		return array;
	}
	
	private void mergeSort(int low, int high) {
		if(low < high) {
			int middle = low + (high - low) / 2;
			
			mergeSort(low, high);
			mergeSort(middle + 1, high);
			merge(low, middle, high);
		}
	}
	
	private void merge(int low, int middle, int high) {
		for(int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while(i <= middle && j <= high) {
			if(helper[i] <= helper[j]) {
				array[k] = helper[i];
				i++;
				
			} else {
				array[k] = helper[i];
				j++;
			}
			
			k++;
		}
		
		while(i <= middle) {
			array[k] = helper[i] ;
			k++;
			i++;
		}
	}

}
