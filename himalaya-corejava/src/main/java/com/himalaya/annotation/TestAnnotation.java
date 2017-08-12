package com.himalaya.annotation;

import java.lang.reflect.Field;
import java.util.Date;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年9月14日 上午10:06:41
* Description
*/
public class TestAnnotation {

	public static void main(String[] args) {
		
		Entity entity = new Entity();
		entity.setId(1);
		entity.setName("fred");
		entity.setRegistDate(new Date());
		Field[] fields = entity.getClass().getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
			FieldMeta meta = field.getAnnotation(FieldMeta.class);
			System.out.println(meta.name());
		}
	}
}
