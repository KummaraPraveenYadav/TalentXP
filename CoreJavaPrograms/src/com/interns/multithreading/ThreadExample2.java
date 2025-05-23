package com.interns.multithreading;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class PrintJob1 implements Runnable {
	String names;

	public PrintJob1(String names) {
		// super();
		this.names = names;

	}

//	@Override // for Callable interface
//	public Object call() throws Exception {
//		System.out.println("Thread is " + Thread.currentThread().getName());
//		// System.out.println("Thread is " + Thread.currentThread().getId());
//		ArrayList<String> al = new ArrayList<String>();
//		al.add(names);
//		return al;
//	}

	@Override // for runnable
	public void run() {
		System.out.println("Thread is " + Thread.currentThread().getName());
		// System.out.println("Thread is " + Thread.currentThread().getId());
		ArrayList<String> al = new ArrayList<String>();
		al.add(names);
		System.out.println(al);
	}

}

public class ThreadExample2 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		PrintJob1[] names = { new PrintJob1("max"), new PrintJob1("harry"), new PrintJob1("virat"),
				new PrintJob1("gayle") };
		ExecutorService service = Executors.newFixedThreadPool(4);
		// we can allocte n number thread to complete the task
		for (PrintJob1 name : names) {
			// System.out.println(service.submit(name));
			Future f = service.submit(name);
			System.out.println(f.get());
		}
		service.close();

	}
}