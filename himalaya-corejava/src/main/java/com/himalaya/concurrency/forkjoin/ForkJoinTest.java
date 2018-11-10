package com.himalaya.concurrency.forkjoin;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.mysql.fabric.FabricStateResponse;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月11日 下午3:42:43
* Description
*/
public class ForkJoinTest {

	private static double[] d;
	
	private static class ForkJoinTask extends RecursiveTask<Integer> {

		private static final long serialVersionUID = 1L;
		
		private int first;
		private int last;
		
		public ForkJoinTask(int first, int last) {
			this.first = first;
			this.last = last;
		}
		
		@Override
		protected Integer compute() {
			int subCount;
			if(last - first < 10){
				subCount = 0;
				for (int i = first; i <= last; i++) {
					if(d[i] < 0.5){
						subCount ++;
					}
				}
			} else {				
				int mid = (first + last)>>>1;
				ForkJoinTask left = new ForkJoinTask(first, mid);
				left.fork();
				ForkJoinTask right = new ForkJoinTask(mid + 1, last);
				right.fork();
				subCount = left.join();
				subCount += right.join();
			}
			return subCount;
		}
	}
	
	public static class ThreadPoolExecutorTask implements Callable<Integer>{

		private int first;
		private int last;
		
		public ThreadPoolExecutorTask(int first, int last) {
			System.out.println("from " + first +" to " + last);
			this.first = first;
			this.last = last;
		}
		
		@Override
		public Integer call() throws Exception {
			int subCount = 0;
			for (int i = first; i <= last; i++) {
				if(d[i] < 0.5){
					subCount ++;
				}
			}
			return subCount;
		}
	}
	
	public static void initArray(int i){
		d = new double[i];
		for (int j = 0; j < i; j++) {
			d[j] = Math.random();
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		int size = 100000000;
		initArray(size);
		long start = System.currentTimeMillis();
		int n = new ForkJoinPool().invoke(new ForkJoinTask(0, size-1));
		System.out.println("Found " + n +" less than 0.5, total cost " + (System.currentTimeMillis()-start));
	
		ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 
															 4, 
															 Long.MAX_VALUE, 
															 TimeUnit.SECONDS, 
															 new LinkedBlockingDeque());
		
		start = System.currentTimeMillis();
		Future[] futures = new Future[4];
		int s = d.length / 4;
		for (int i = 0; i < 4; i++) {
			futures[i] = executor.submit(new ThreadPoolExecutorTask(i*s, (i+1)*s-1));
		}
		n = 0;
		for (int i = 0; i < futures.length; i++) {
			n += (Integer)futures[i].get();
		}
		
		System.out.println("Found " + n +" less than 0.5, total cost " + (System.currentTimeMillis()-start));
	}
}
