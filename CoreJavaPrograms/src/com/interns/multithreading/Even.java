package com.interns.multithreading;

public class Even implements Runnable{
	@Override
	public synchronized void run() {
		for(int i=0;i<=20;i++)
		{
			try {
				//notify();
				//wait();
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i%2==0)
				System.out.println("Even number -" +i);
		}
	}
}
