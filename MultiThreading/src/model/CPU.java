package model;

import java.util.Random;

/**
 * Class that defines main CPU. Includes two process queue 
 * and treat them.
 * @author Tribel
 *
 */
public class CPU extends Thread{

	private CpuQueue firstProcess;
	private CpuQueue secondProcess;
	
	/**
	 * Constructor that defines both of queue
	 * @param queue first process queue
	 * @param queue2 second process queue
	 */
	public CPU(CpuQueue queue, CpuQueue queue2) {
		this.firstProcess = queue;
		this.secondProcess = queue2;
	}
	
	
	@Override
	public void run() {
		System.out.println("Main CPU is running");
		
		ProcessObserver observer = new ProcessObserver();
		while(!isInterrupted()) {
				
			if(!observer.isProcessDropped()) {
				
				if(new Random().nextInt(3) % 2 == 0) {
					observer = new ProcessObserver(firstProcess, secondProcess, firstProcess.peekProcess());
				} else {
					observer = new ProcessObserver(secondProcess, firstProcess, secondProcess.peekProcess());
				}
				
			} else {
				observer = new ProcessObserver(observer.changeProcessAfterDroping());
				
			}	
				
			try {
				observer.start();
				System.out.println("Treating the process by CPU" );
				Thread.sleep(3000);
				observer.interrupt();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				return;
			}
			
			
		}
		
	}
	
	
	
}
