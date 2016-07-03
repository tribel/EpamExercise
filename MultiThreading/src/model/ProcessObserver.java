package model;

public class ProcessObserver extends Thread{

	private  CpuQueue currentQueue;
	private CpuQueue secondaryQueue;
	private  int currnetQueueSize;
	private  int scdrQuequSize;
	private  CpuProcess currentProcess;
	private boolean dropedProcessFlag;
	
	public ProcessObserver() {
	}
	
	public ProcessObserver(CpuQueue currentQueue,CpuQueue queue, CpuProcess process) {
		buildProcessObserver(currentQueue, queue, process);
	}
	
	public ProcessObserver(ProcessObserver observer) {
		buildProcessObserver(observer.getCurrentQueue(),
				observer.getSecondaryQueue(), observer.getCurrentProcess());
	}
	
	@Override
	public void run() {
		System.out.println("Process observer is running");
		
		while(!isInterrupted()) {
			
			if(currentQueue.getSize() != currnetQueueSize) {
				currentQueue.loseProcess(currentProcess);
				break;
			}
			
			if(secondaryQueue.getSize() != scdrQuequSize) {
				currentQueue.dropProcess(currentProcess);
				dropedProcessFlag = true;
				break;
			}
		}
		System.out.println("Observer is interrupt");
	}
	
	
	public boolean isProcessDropped() {
		return dropedProcessFlag;
	}
	
	public ProcessObserver buildProcessObserver(CpuQueue currentQueue,CpuQueue queue, CpuProcess process) {
		System.out.println("Process observer filling");
		this.currentQueue = currentQueue;
		this.secondaryQueue = queue;
		this.currnetQueueSize = currentQueue.getSize();
		this.scdrQuequSize = queue.getSize();
		this.currentProcess = process;
		this.dropedProcessFlag = false;
		return this;
	}
	
	public ProcessObserver changeProcessAfterDroping() {
		System.out.println("Changing process after droping another one.");
		return buildProcessObserver(secondaryQueue, currentQueue, secondaryQueue.peekProcess());
	}

	public CpuQueue getCurrentQueue() {
		return currentQueue;
	}

	public CpuQueue getSecondaryQueue() {
		return secondaryQueue;
	}

	public CpuProcess getCurrentProcess() {
		return currentProcess;
	}
	
	
	
}
