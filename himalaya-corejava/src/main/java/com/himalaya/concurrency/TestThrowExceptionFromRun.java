package com.himalaya.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThrowExceptionFromRun {

	public static void main(String[] args) {
		
		try {
			
			ExecutorService es = Executors.newFixedThreadPool(2);
			final CountDownLatch countDownLatch = new CountDownLatch(2);
					
			for (int i = 0; i < 2; i++) {
				es.execute(new Runnable() {
					
					public void run() {
						try {
							System.out.println(Thread.currentThread().getName() + ", Thread started......");
							if(true){
								throw new Exception("Exception during execute task.");
							}
							System.out.println(Thread.currentThread().getName() + ", Thread ended......");
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							countDownLatch.countDown();
						}
					}
				});
			}
			
			countDownLatch.await();
			es.shutdown();
			System.out.println("Executer is down");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
