package com.interns.multithreading;

public class Odd implements Runnable{

	
	public synchronized void run() {
		for(int i=0;i<=20;i++)
		{
			try {
				Thread.sleep(2);
				//wait();
				//notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(i%2!=0)
				System.out.println("Odd number -" +i);		}
		
	}
	

}
