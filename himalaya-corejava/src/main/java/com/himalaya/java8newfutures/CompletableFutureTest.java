package com.himalaya.java8newfutures;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author Fred
 * @Create on 2019/7/6.
 * @Description com.himalaya
 */
public class CompletableFutureTest {

    private static Executor executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        CompletableFutureTest test = new CompletableFutureTest();
        test.test();
        System.out.println("=========================");
        test.test1();
    }

    public void test() {
        List<Pair> pairs = Lists.newArrayList();
        pairs.add(new ImmutablePair("1", "fred1"));
        pairs.add(new ImmutablePair("2", "fred2"));
        pairs.add(new ImmutablePair("3", "fred3"));
        pairs.add(new ImmutablePair("4", "fred4"));
        pairs.add(new ImmutablePair("5", "fred5"));

        List<String> resultList = Lists.newArrayList();

        CompletableFuture<?>[] cfs = pairs.stream().map(pair -> {
            String left = (String)pair.getLeft();
            String right = (String)pair.getRight();
            return CompletableFuture.supplyAsync(() -> this.getReport(left, right), executor)
                    .whenComplete((result, e) -> {
                        if (result == null) {
                            System.out.println("result is null");
                        }
                        resultList.add(result);
                        System.out.println("get report result is " + result);
                    });
        }).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(cfs).join();
        System.out.println("Finished");

        resultList.forEach(item -> {
            System.out.println(item);
        });
    }

    public void test1() {

        Map<String, String> map = Maps.newHashMap();
        map.put("1", "fred1");
        map.put("2", "fred2");
        map.put("3", "fred3");
        map.put("4", "fred4");
        map.put("5", "fred5");

        List<String> resultList = Lists.newArrayList();

        CompletableFuture<?>[] cfs = map.entrySet().stream().map(pair -> {
            String left = pair.getKey();
            String right = pair.getValue();
            return CompletableFuture.supplyAsync(() -> this.getReport(left, right), executor)
                    .whenComplete((result, e) -> {
                        if (result == null) {
                            System.out.println("result is null");
                        }
                        resultList.add(result);
                        System.out.println("get report result is " + result);
                    });
        }).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(cfs).join();
        System.out.println("Finished");

        resultList.forEach(item -> {
            System.out.println(item);
        });
    }

    public String getReport(String left, String right) {
        System.out.println("left : " + left + ", right : " + right);
        Integer sleepTime = Integer.parseInt(left);
        try {
            Thread.sleep(sleepTime*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (left == "1") {
            return null;
        }
        return left + right;
    }
}
