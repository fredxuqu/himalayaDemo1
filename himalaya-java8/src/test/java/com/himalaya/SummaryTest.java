package com.himalaya;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import himalayaJava8.Apple;

public class SummaryTest {

	@Test
	public void testSort(){
		
		List<Apple> apples = Lists.newArrayList();
		Apple apple = new Apple("Green", 1.2);
		apples.add(new Apple("Green", 1.2));
	}

	@Test
	public void testLambda(){
		System.out.println("============");
	}
}
