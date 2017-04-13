package com.himalaya.concurrency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeGenerater implements Runnable{

	private volatile boolean canceled = false;
	
//	@GuardedBy("this")
	private List<BigInteger> primes = new ArrayList<BigInteger>();
	
	public void run() {
		BigInteger p = BigInteger.ONE;
		while(!canceled){
			System.out.println(canceled);
			p = p.nextProbablePrime();
			synchronized(this){
				primes.add(p);
			}
		}
	}
	
	public void cancel(){
		this.canceled = true;
	}
	
	public List<BigInteger> getPrimes(){
		return new ArrayList<BigInteger>(primes);
	}
	
	public static void main(String[] args) {
		PrimeGenerater pg = new PrimeGenerater();
		new Thread(pg).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			pg.cancel();
		}
		
		System.out.println(pg.getPrimes());
	}
}

