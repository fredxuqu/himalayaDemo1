package com.himalaya.model;

public class LogInfo {
	
	private String id;
	private String msg;
	private String appId;
	private int logLevel;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public int getLogLevel() {
		return logLevel;
	}
	public void setLogLevel(int logLevel) {
		this.logLevel = logLevel;
	}	
	
	public String toString(){
		return id + " ; " + msg;
	}
}
