package model;

import java.util.Random;


public class CPU extends Thread{
	ProcessProduser produser;
	ProcessProduser produser2;
	
	public CPU() {
	}
	
	public CPU(ProcessProduser produser, ProcessProduser produser2) {
		this.produser = produser;
		this.produser2 = produser2;
	}

	@Override
	public void run() {
		System.out.println("Main CPU is running");
		
		boolean changeProduserFlag = false;
		produser = new ProcessProduser(this, "First");
		produser2 = new ProcessProduser(this, "Second");
		
		produser2.start();
		produser.start();
				
		CpuProcess prcs = null, secondaryPrcs = null;
		ProcessProduser cpuCrntProduser = null, secondaryProduser = null;
		
		while(!isInterrupted() ) {		
			
			if(changeProduserFlag) {
				ProcessProduser tmp = cpuCrntProduser;
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
	
	
	public ProcessProduser getFirstProduser() {
		return produser;
	}
	
	public ProcessProduser getSecondProduser() {
		return produser2;
	}
	
}
