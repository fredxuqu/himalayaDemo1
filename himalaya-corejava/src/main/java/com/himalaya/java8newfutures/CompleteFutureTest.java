package com.himalaya.java8newfutures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.sun.tools.javac.util.Pair;

import lombok.AllArgsConstructor;
import lombok.Data;


public class CompleteFutureTest {

	public static void main(String[] args) {
		
		List<String> alpha = Arrays.asList("a", "b", "c", "d");
		List collections = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(collections);
		
		
		List<Pair<String, String>> pairs = Lists.newArrayList();
		pairs.add(new Pair<String, String>("aaa", "111"));
		pairs.add(new Pair<String, String>("bbb", "222"));
		pairs.add(new Pair<String, String>("ccc", "333"));
		pairs.add(new Pair<String, String>("ccc", "444"));
		
		CompletableFuture<?>[] cfs = pairs.stream().map(pair -> {
			
		}).toArray(CompletableFuture::new);
	}
}
