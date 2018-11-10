package com.himalaya.jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月4日 上午10:55:22
* Description
* 
* setting -verbose:gc -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PermSize=10m -XX:MaxPermSize=10m -XX:+HeapDumpOnOutOfMemoryError
*/
public class ConstantPoolOOMDemo {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		int i=0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}
}
