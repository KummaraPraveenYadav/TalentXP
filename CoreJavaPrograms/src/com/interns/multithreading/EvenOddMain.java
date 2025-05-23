package com.interns.multithreading;

public class EvenOddMain {
	public static void main(String[] args) throws InterruptedException {
		Even e = new Even();
		Odd o = new Odd();
	
		Thread t1= new Thread(e);
		Thread t2 = new Thread(o);
		t1.start();
		t1.join();
		t2.start();
		
	}
}
