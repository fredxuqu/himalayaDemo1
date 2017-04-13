package com.himalaya.gof23.singleton;

public class StaticInnerClassModel {
	
	public static class SingletonHolder{
		private static StaticInnerClassModel instance = new StaticInnerClassModel();
	}
	
	private StaticInnerClassModel(){
	}
	
	public static StaticInnerClassModel getInstance(){
		return SingletonHolder.instance;
	}
	
	public static void main(String[] args) {
		
		System.out.println(StaticInnerClassModel.getInstance());
	}
}
