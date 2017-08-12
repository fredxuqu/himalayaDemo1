package com.himalaya.annotation;

import java.util.Date;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年9月14日 上午9:31:42
* Description
*/
public class Entity {

	@FieldMeta(name="主键ID", order=1)
	int id;
	
	@FieldMeta(name="名称", order=2)
	String name;
	
	@FieldMeta(name="注册日期", order=3)
	Date registDate;
	
	@FieldMeta(desc="描述", order=3)
	String desc(){
		return "Java reflect - get annotation description.";
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

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	} 
}
