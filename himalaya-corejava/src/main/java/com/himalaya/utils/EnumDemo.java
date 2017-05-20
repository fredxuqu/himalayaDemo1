package com.himalaya.utils;

public enum EnumDemo { 
	
	Normal("Normal", 1), Update("Updated", 2), Deleted("Deleted", 3), Fired("Fired", 4);
	
	private String key;
	private int value;
	
	private EnumDemo(String key, int value){
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}