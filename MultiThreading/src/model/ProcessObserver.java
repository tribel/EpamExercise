package model;

public class ProcessObserver extends Thread{

	private final CpuQueue currentQueue;
	private CpuQueue secondaryQueue;
	private final int currnetQueueSize;
	private final int scdrQuequSize;
	private final CpuProcess currentProcess;
	private boolean dropedProcessFlag;
	
	public ProcessObserver(CpuQueue currentQueue,CpuQueue queue, CpuProcess process) {
		this.currentQueue = currentQueue;
		this.secondaryQueue = queue;
		this.currnetQueueSize = currentQueue.getSize();
		this.scdrQuequSize = queue.getSize();
		this.currentProcess = process;
	}
	
	@Override
	public void run() {
		System.out.println("Process observer is running");
		
		while(!isInterrupted()) {
			
			if(currentQueue.getSize() != currnetQueueSize) {
				currentQueue.loseProcess(currentProcess);
			}
			
			if(secondaryQueue.getSize() != scdrQuequSize) {
				currentQueue.dropProcess(currentProcess);
				dropedProcessFlag = true;
			}
		}	
	}
	
	
	public boolean isProcessDropped() {
		return dropedProcessFlag;
	}
	
}
