
public class Summation extends Thread{

	private int[] array;
	private int begin;
	private int end;
	private int resultSum;
	
	public Summation() {
		array = new int[0];
	}
	
	public Summation(int[] array, int begin, int end) {
		this.array = array;
		this.begin = begin;
		this.end = end;
	}
	
	@Override
	public void run() {
		resultSum = 0;
		for(int i = begin; i < end; i++) {
			resultSum += Math.exp( Math.sin( array[i] ));
		}
	}
	
	public int getResultSum() {
		return resultSum;
	}
	
	
	public static void main(String[] args) {
		int[] sourceArray = {4,6,5,8,9,5,9,5,8,8,8,6,5,4,5,4,5,8,5,1,2,4,2,4,9,4,5,7,5,4,8,2,4,87,2,8,7};
		
		Summation summation = new Summation(sourceArray, 0, sourceArray.length/2);
		Summation summation2 = new Summation(sourceArray, sourceArray.length/2, sourceArray.length);
		
		summation.run();
		summation2.run();
		
		try {
			summation.join();
			summation2.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		
		System.out.println(summation.getResultSum() + summation2.getResultSum());
	}
}
