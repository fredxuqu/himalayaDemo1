package com.himalaya.dto;

import java.io.IOException;
import java.io.Serializable;

import com.alibaba.dubbo.common.json.JSON;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年8月8日 下午5:37:59
* Description
*/
public class UserDTO implements Serializable {
	
	private int id;
	private String name;
	private String pwd;
	
	public UserDTO(){
	}
	
	public UserDTO(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String toString(){
		try {
			return JSON.json(this).toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
