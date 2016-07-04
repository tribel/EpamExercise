package model;

import java.util.LinkedList;

/**
 * Class {@link CpuQueue} that realize process
 * relationship between each other in one queue.
 * @author Tribel
 *
 */
public class CpuQueue {

	/**
	 * Process list
	 */
	private LinkedList<CpuProcess> queue = new LinkedList<>();
	
	private volatile int dropCounter;
	
	/**
	 * DEfault constructor
	 */
	public CpuQueue() {
	}
	
	/**
	 * Adding to the queue one process.
	 * @param process {@link CpuProcess} that will be added.
	 */
	public synchronized void addToQueue(CpuProcess process) {
		queue.add(process);
		notifyAll();
		
	}
	
	/**
	 * Losing concrete process from the queue. Actually it
	 * will be removed, but losing is statistic data.
	 * @param process {@link CpuProcess} that will be lose.
	 */
	public synchronized void loseProcess(CpuProcess process) {		
		System.out.println("Losing the process " + process.getProcessId() 
												 + process.getName());
		if(queue.size() != 0) queue.remove(process);

	}
	
	/**
	 * Drop the concrete process from queue. Actually it
	 * will be removed, but drop is statistic data.
	 * @param process {@link CpuProcess}
	 */
	public synchronized void dropProcess(CpuProcess process) {
		System.out.println("Droping the process " + process.getProcessId()
				  + process.getName());
		
		if(queue.size() != 0) queue.remove(process);
		
		dropCounter += 1;
	}
	
	/**
	 * Get the first object from the queue.
	 * @return first {@link CpuProcess} object.
	 */
	public synchronized CpuProcess peekProcess() {
		return queue.getFirst();
	}
 	
	/**
	 * Returning {@link Integer} current queue size. 
	 * @return queue size.
	 */
	public int getSize() {
		return queue.size();
	}

	public int getDropCounter() {
		return dropCounter;
	}

	@Override
	public String toString() {
		return "CpuQueue [queue=" + queue + "]";
	}
	
	
 	
}
