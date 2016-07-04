package main;

import java.util.Random;

import model.CPU;
import model.CpuProcess;
import model.CpuQueue;
import model.ProcessProduser;


public class Main {
	
	public static final int RANDOM_BOUND = 100;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		CpuQueue queue1 = new CpuQueue();
		CpuQueue queue2 = new CpuQueue();
		
		fillQueue(queue1);
		fillQueue(queue2);
		
		System.out.println("First queue before start" + queue1);
		System.out.println("Second queue before start" + queue2);
		
		CPU cpu = new CPU(queue1, queue2);
		ProcessProduser produser = new ProcessProduser(queue1);
		ProcessProduser produser2 = new ProcessProduser(queue2);
		
		cpu.start();
		produser.start();
		produser2.start();
		
		Thread.sleep(30000);
		
		cpu.interrupt();
		produser.interrupt();
		produser2.interrupt();
		
		cpu.join();
		produser.join();
		produser2.join();
	
		System.out.println((double)queue1.getDropCounter()/queue1.getSize() * 100 
							+  " - result for first queue");
		System.out.println((double)queue2.getDropCounter()/queue2.getSize() * 100 
							+ "- result second queue");
		
	}
	
	
	static void fillQueue(CpuQueue queue) {
		for(int i = 0; i < 3; i++) {
			queue.addToQueue(new CpuProcess(new Random().nextInt(RANDOM_BOUND), 
														"prcss" + RANDOM_BOUND));
		}
	}
}
