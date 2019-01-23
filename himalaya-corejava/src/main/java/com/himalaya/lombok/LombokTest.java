package com.himalaya.lombok;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2019年1月4日 下午4:17:56
* Description
*/
@Data
@NoArgsConstructor
public class LombokTest {

	private int id;
	private String name;
	
	
	public static void main(String[] args) {
		LombokTest test = new LombokTest();
		test.setId(1234);
		test.setName("fred");
		System.out.println(test.toString());
	}
}
