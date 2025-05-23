package com.interns.multithreading;

import java.security.PrivateKey;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample4 {

		private static ExecutorService pool =  Executors.newFixedThreadPool(10);
		private static SimpleDateFormat  df = new SimpleDateFormat("yyyy-mm-dd");
		
		public String birthDate(int userId)
		{
			//Date d = new Date();
			Date d = new Date(userId);
			return df.format(d);
		}
		public static void main(String[] args) throws InterruptedException,ExecutionException {
			//THREAD sLOCAL
			for(int i =0;i<10;i++)
			{
				int userId = i;
				pool.submit(() ->{
					//int userId = 0;
					String date = new ThreadExample4().birthDate(userId);
					System.out.println(date);
				});
			}
			Thread.sleep(100);
	}

}
