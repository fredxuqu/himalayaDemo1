package com.himalaya.performance;

public class FibImpl {
	
	public void doTest(){
		
		double l;
		long then = System.currentTimeMillis();
		for (int i = 0; i < 40; i++) {
			l = fibImpl(i);
		}
		long now = System.currentTimeMillis();
		System.out.println(now - then);
	}
	
	public double fibImpl(int i){
		
		//System.out.println("do impl");
		if(i==0){return 0d;}
		if(i==1) {return 1d;}
		double d = fibImpl(i-2) + fibImpl(i-1);
		return d;
	}
	
	public static void main(String[] args) {
		FibImpl impl = new FibImpl();
		impl.doTest();
	}
}
