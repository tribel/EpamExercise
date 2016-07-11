package model;

import java.util.Random;

/**
 * Main Cpu that treats the processes, creating by 
 * two producers.
 * @author Tribel
 *
 */
public class CPU extends Thread{
	ProcessProducer produser;
	ProcessProducer produser2;
	
	/**
	 * Default constructor.
	 */
	public CPU() {
	}
	
	/**
	 * Constructor that define both of the Producers.
	 * @param produser {@link ProcessProducer} first producer.
	 * @param produser2 {@link ProcessProducer} second producer.
	 */
	public CPU(ProcessProducer produser, ProcessProducer produser2) {
		this.produser = produser;
		this.produser2 = produser2;
	}

	@Override
	public void run() {
		System.out.println("Main CPU is running");
		
		boolean changeProduserFlag = false;
		produser = new ProcessProducer(this, "First");
		produser2 = new ProcessProducer(this, "Second");
		
		produser2.start();
		produser.start();
				
		CpuProcess prcs = null, secondaryPrcs = null;
		ProcessProducer cpuCrntProduser = null, secondaryProduser = null;
		
		while(!isInterrupted() ) {		
			
			if(changeProduserFlag) {
				ProcessProducer tmp = cpuCrntProduser;
				cpuCrntProduser = secondaryProduser;
				secondaryProduser = tmp;
			} else {
				if(new Random().nextInt(20) % 2 == 0) {
					cpuCrntProduser = produser2;
					secondaryProduser = produser;
				} else {
					cpuCrntProduser = produser;
					secondaryProduser = produser2;
				}
			}
			
			
			try {
				synchronized (this) {
					changeProduserFlag = false;
					secondaryPrcs = secondaryProduser.getCurrentProcess();
					prcs = cpuCrntProduser.getCurrentProcess();
					System.out.println("Treating the process by CPU" + prcs + "--Name - " + cpuCrntProduser.getpName());
					System.out.println("Waiting");

					this.wait(3000);

					System.out.println("CPU stop waiting ");
				}

				if (prcs != cpuCrntProduser.getCurrentProcess()) {
					cpuCrntProduser.incLost();
					System.out.println("Cpu was notified by  CURRENT same Produser");
				
				} else if(secondaryPrcs != secondaryProduser.getCurrentProcess()) {
					cpuCrntProduser.incDropped();
					changeProduserFlag = true;
					System.out.println("Cpu was notified by ANOTHER Produser");
				
				} else {
					
					System.out.println("Cpu was notified by itself.");
				}

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				produser.interrupt();
				produser2.interrupt();
				
				return;
			} 
			
		}	
		
		try {
			produser.join();
			produser2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	
	public ProcessProducer getFirstProduser() {
		return produser;
	}
	
	public ProcessProducer getSecondProduser() {
		return produser2;
	}
	
}
