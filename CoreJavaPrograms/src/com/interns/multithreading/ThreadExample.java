package com.interns.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

 class PrintJob implements Callable {
	int num;

	public PrintJob(int num) {
		this.num=num;

	}

	@Override
	public Object call() throws Exception {
		System.out.println("Thread is " + Thread.currentThread().getName());
		//System.out.println("Thread is " + Thread.currentThread().getId());
		int sum = 0;
		for (int i = 0; i <= num; i++) {
		
			sum += i;

		}
		
		return sum;
	}

}
public class ThreadExample{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		PrintJob[] jobs = {new PrintJob(10),
				           new PrintJob(20),
				           new PrintJob(30),
				           new PrintJob(40)
				         };
		ExecutorService service = Executors.newFixedThreadPool(4);
		// we can allocte n number thread to complete the task
		for(PrintJob job:jobs)
		{
			//System.out.println(service.submit(job));
			Future f = service.submit(job);
			System.out.println(f.get());
		}
		service.close();
		
	}
}