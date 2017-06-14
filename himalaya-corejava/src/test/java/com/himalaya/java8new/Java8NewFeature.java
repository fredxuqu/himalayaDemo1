package com.himalaya.java8new;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2017年6月9日 下午1:49:53 Description
 */
public class Java8NewFeature {

	public static void main(String[] args) {

		Runnable task;
		// lambda expression
		Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));

		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.println(e));

		Arrays.asList("a", "b", "d").forEach((String e) -> {
			System.out.println("- " + e);
			System.out.println("- " + e);
		});

		final String separator = ",";
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + separator));

		System.out.println();
		List<String> list = Arrays.asList("c", "b", "a");
		list.sort((e1, e2) -> e1.compareTo(e2));
		list.forEach(e -> System.out.println(e));

		Arrays.asList("a", "b", "d").sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			return result;
		});

		Functional.create();

		Functional func = new FunctionalImpl();
		func.method();
		func.defaultMethod();

		final Car car = Car.create(Car::new);
		car.repair();
		final List<Car> cars = Arrays.asList(car);
		
		cars.forEach(Car::collide);
		
		cars.forEach(Car::repair);
		
		Car car1 = Car.create(Car::new);
		cars.forEach(car1::follow);
	}

	public static class Car {
		public static Car create(final Supplier<Car> supplier) {
			return supplier.get();
		}

		public static void collide(final Car car) {
			System.out.println("Collided " + car.toString());
		}

		public void follow(final Car another) {
			System.out.println("Following the " + another.toString());
		}

		public void repair() {
			System.out.println("Repaired " + this.toString());
		}
	}
}

// 函数式接口就是一个具有一个方法的普通接口
@FunctionalInterface
interface Functional {

	void method();

	default void defaultMethod() {
		System.out.println("Common method in Functional Method");
	}

	static void create() {
		System.out.println("Static method in Functional!");
	}
}

class FunctionalImpl implements Functional {

	@Override
	public void method() {
		System.out.println("FUNCTIONAL METHOD");
	}
}
