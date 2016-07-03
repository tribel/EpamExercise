package model;

import java.util.LinkedList;

public class CpuQueue {

	private LinkedList<CpuProcess> queue = new LinkedList<>();
	
	public CpuQueue() {
	}
	
	public synchronized void addToQueue(CpuProcess process) {
		queue.add(process);
		notifyAll();
		
	}
	
	public synchronized void loseProcess(CpuProcess process) {		
		System.out.println("Losing the process " + process.getProcessId() 
												 + process.getName());
		if(queue.size() != 0) queue.remove(process);
	}
	
	public synchronized void dropProcess(CpuProcess process) {
		System.out.println("Droping the process " + process.getProcessId()
				  + process.getName());
		
		if(queue.size() != 0) queue.remove(process);
	}
	
	public synchronized CpuProcess peekProcess() {
		return queue.getFirst();
	}
 	
	public int getSize() {
		return queue.size();
	}

	@Override
	public String toString() {
		return "CpuQueue [queue=" + queue + "]";
	}
	
	
 	
}
