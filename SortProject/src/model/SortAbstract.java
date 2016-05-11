package model;

public abstract class SortAbstract {

	protected int[] array;
	
	public abstract int[] sort();
	
	public void setArray(int[] array) {
		this.array = array;
	}
	
	public int[] getArray() {
		return this.array;		
	}
	
	protected void swap(int i , int j) {
		int tmpValue = array[i];
		array[i] = array[j];
		array[j] = tmpValue;
	}

}
