package model;

import java.util.Random;


public class ProcessProduser extends Thread{

	private volatile CpuProcess currentProcess;
	private int createdProcessCount;
	private int lostProcessCount;
	private int droppedProcessCount;
	CPU cpu;
	String prcsName;
	

	public ProcessProduser(CPU cpu, String name ) {
		this.cpu = cpu;
		this.prcsName = name;
	}
	
	@Override
	public void run() {
		System.out.println("Process produser is running");
		
		int i = 0;
		while(!isInterrupted()) {
			
			try {
				synchronized (cpu) {
					Thread.sleep(getRandomSleepTime() * 1000);
					currentProcess = new CpuProcess(++i, "process" + prcsName + String.valueOf(i));
	
					System.out.println("Add process from producer" + prcsName);
					createdProcessCount += 1;

					cpu.notify();

					System.out.println("Notify by" + prcsName);

				}
				
				synchronized(this) {
					System.out.println("Produser"+ prcsName + " waiting");
					this.wait(2000);
				}
				
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				return;
			}
		}
	}

	
	public int getRandomSleepTime() {
		return new Random().nextInt(2);
	}
	
	public synchronized int getCreatedProcessCount() {
		return createdProcessCount;
	}
	
	public synchronized CpuProcess getCurrentProcess() {
		return currentProcess;
	}

	public String getpName() {
		return prcsName;
	}
	
	public synchronized void incLost() {
		lostProcessCount++;
	}
	
	public synchronized void incDropped() {
		droppedProcessCount++;
	}
	
	public int getLosedProcessCount() {
		return lostProcessCount;
	}
	
	public int getDroppedProcessCount() {
		return droppedProcessCount;
	}
	
	
	
}
