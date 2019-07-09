package himalayaJava8;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Apple {

    private String color;
    private Double weight;


    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 1.0d;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> apples = Lists.newArrayList();
        inventory.forEach(apple -> {
            if (predicate.test(apple)) {
                apples.add(apple);
            }
        });
        return apples;
    }

    public static void main(String[] args) {
        List<Apple> apples = Lists.newArrayList();
        apples.add(new Apple("green", 1.4d));
        apples.add(new Apple("red", 2.4d));
        apples.add(new Apple("green", 0.4d));

        List<Apple> appleList = filterApples(apples, new GreenApple());
        appleList.forEach(System.out::println);

        System.out.println();

        List<Apple> appleHeavyList = filterApples(apples, new HeavyApple());
        appleHeavyList.forEach(System.out::println);

        System.out.println();
        List<Apple> appleList1 = filterApples(apples, (Apple a) -> "green".equals(a.getColor()));
        appleList1.forEach(System.out::println);


        System.out.println();
        List<Apple> appleList2 = filterApples(apples, (Apple a) -> a.getWeight() > 1.0);
        appleList2.forEach(System.out::println);
    }
}

interface Predicate<T> {
    boolean test(T t);
}

class GreenApple implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}

class HeavyApple implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 1.0d;
    }
}
