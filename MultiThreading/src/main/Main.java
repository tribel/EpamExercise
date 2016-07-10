package main;


import model.CPU;


public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		CPU cpu = new CPU();
		cpu.start();
		Thread.sleep(20000);
		
		cpu.interrupt();
		cpu.join();
		
		float percent1 = (float)cpu.getFirstProduser().getDroppedProcessCount() / 
							cpu.getFirstProduser().getCreatedProcessCount();

		float percent2 = (float)cpu.getSecondProduser().getDroppedProcessCount() / 
							cpu.getSecondProduser().getCreatedProcessCount();
		

		System.out.println("----------------------------------------------");
		System.out.println("Percent of first produser"+  percent1 * 100);
		System.out.println("Percent of second produser" + percent2 * 100);
		
	}
	

}
