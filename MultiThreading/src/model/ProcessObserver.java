package model;

/**
 * Class that observer for the process in main CPU.
 * Will start when main CPU will be treating the process.
 * @author Tribel
 *
 */
public class ProcessObserver extends Thread{

	/**
	 * Current queue, that will assume like a main queue.
	 */
	private CpuQueue currentQueue;
	
	/**
	 * Secondary queue,
	 */
	private CpuQueue secondaryQueue;
	
	/**
	 * {@link Integer} size of the current queue
	 */
	private  int currnetQueueSize;
	
	/**
	 * {@link Integer} size of the secondary queue.
	 */
	private  int scdrQuequSize;
	
	/**
	 * Process the will be treating in the moment.
	 */
	private  CpuProcess currentProcess;
	
	/**
	 * {@link Boolean} flag that will be true - if
	 * process from the queue will be drop, in another cases - false.
	 */
	private boolean dropedProcessFlag;
	
	
	/**
	 * Default constructor
	 */
	public ProcessObserver() {
	}
	
	/**
	 * Constructor that defines both of queues 
	 * @param currentQueue current queue
	 * @param queue secondary queue
	 * @param process current process.
	 */
	public ProcessObserver(CpuQueue currentQueue,CpuQueue queue, CpuProcess process) {
		buildProcessObserver(currentQueue, queue, process);
	}
	
	/**
	 * Constructor that build the object likeness another object,
	 * but does not clone it.
	 * @param observer {@link ProcessObserver} object.
	 */
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
	
	
	/**
	 * Method for detection process behavior.
	 * @return true - if process was dropped, false - if wasn`t.
	 */
	public boolean isProcessDropped() {
		return dropedProcessFlag;
	}
	
	/**
	 * Create the {@link ProcessObserver} object
	 * @param currentQueue current queue
	 * @param queue secondary queue.
	 * @param process current process
	 * @return construct object.
	 */
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
	
	/**
	 * Changing the reference of the current and secondary queue. 
	 * @return {@link ProcessObserver} object, with reference changing.
	 */
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
