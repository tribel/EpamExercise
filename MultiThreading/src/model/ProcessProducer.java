package model;

import java.util.Random;


/**
 * Class that creates {@link CpuProcess} entities
 * that will be have deal with CPU.
 * @author Tribel
 *
 */
public class ProcessProducer extends Thread{

	/**
	 * Last process that created by producer.
	 */
	private volatile CpuProcess currentProcess;
	
	/**
	 * The total created process count.
	 */
	private int createdProcessCount;
	
	/**
	 * The total lost processes count.
	 */
	private int lostProcessCount;
	
	/**
	 * The total dropped processes count.
	 */
	private int droppedProcessCount;
	
	/**
	 * Cpu that will be accept producers processes.
	 */
	CPU cpu;
	
	/**
	 * Name of the producer.
	 */
	String prcsName;
	

	/**
	 * Constructor taht define CPU and producer name.
	 * @param cpu {@link CPU} that will be have deal with producer.
	 * @param name {@link String} producer name.
	 */
	public ProcessProducer(CPU cpu, String name ) {
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

	
	/**
	 * Generate {@link Integer} time sleep value
	 * @return 0 or 1 in random case.
	 */
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
	
	/**
	 * Increment the lost process value.
	 */
	public synchronized void incLost() {
		lostProcessCount++;
	}
	
	/**
	 * Increment the dropped process value.
	 */
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
