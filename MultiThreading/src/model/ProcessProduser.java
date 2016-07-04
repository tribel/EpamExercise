package model;

/**
 * Class that add the {@link CpuProcess} objects in some queue,
 * during main CPU is running.
 * @author Tribel
 *
 */
public class ProcessProduser extends Thread{

	private CpuQueue queue;
	
	/**
	 * Constructor that defines queue in what
	 * will be {@link CpuProcess} added. 
	 * @param queue 
	 */
	public ProcessProduser(CpuQueue queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("Process produser is running");
		
		int i = 0;
		while(!isInterrupted()) {
			try {
				Thread.sleep(3000);
				queue.addToQueue(new CpuProcess(++i, "process " + String.valueOf(i)));
				
				System.out.println("Add process to queue from producer");
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				return;
			}
		}
		
	}

	
}
