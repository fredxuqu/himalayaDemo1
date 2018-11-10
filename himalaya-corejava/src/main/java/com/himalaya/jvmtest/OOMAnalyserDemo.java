package com.himalaya.jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月4日 上午9:08:28
* Description
* 
* setting -verbose:gc -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
*/
public class OOMAnalyserDemo {

	static class OOMObject{
	} 
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}
