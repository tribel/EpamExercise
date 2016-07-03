package model;

public class ProcessProduser extends Thread{

	private CpuQueue queue;
	
	public ProcessProduser(CpuQueue queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("Process produser is running");
		
		int i = 0;
		while(!isInterrupted()) {
			try {
				Thread.sleep(2000);
				queue.addToQueue(new CpuProcess(++i, "process" + String.valueOf(i)));
				
				System.out.println("Add process to queue from producer");
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	
}
