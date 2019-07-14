package com.himalaya.java8newfutures;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: anna
 * @create on: 2019-07-14 10:07 PM
 * @description:
 */
public class LambdaTest {

    public static void main(String[] args) {
        List<Apple> appleList = Lists.newArrayList();
        appleList.add(new Apple("green", 12.4));
        appleList.add(new Apple("red", 10.4));
        appleList.add(new Apple("green", 11.4));
        appleList.add(new Apple("yellow", 9.4));

        Filter<Apple> filter = new Filter<>();
        List<Apple> remainList = filter.filter(appleList,
                (Apple apple) -> "green".equals(apple.getColor()) && apple.getWeight() > 12);
        remainList.forEach(e -> System.out.println(e));

        System.out.println();
        appleList.sort((Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor()));
        appleList.forEach(e -> System.out.println(e.toString()));

        System.out.println();
        appleList.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        appleList.forEach(e -> System.out.println(e.toString()));

        Thread t = new Thread(() -> System.out.println("Task is running "));
        t.start();
    }
}



interface Predicate<T>{
    boolean test(T t);
}

class Filter<T> {
    public List<T> filter(List<T> list, Predicate<T> p){
        List<T> remainList = Lists.newArrayList();
        list.forEach(e ->{
            if(p.test(e)){
                remainList.add(e);
            }
        });
        return remainList;
    }
}


