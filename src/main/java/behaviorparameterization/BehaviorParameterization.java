package behaviorparameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class BehaviorParameterization {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);

        List<Apple> greenApples2 = filterApplesByColor(inventory, "green");
        System.out.println(greenApples2);

        List<Apple> redApples = filterApplesByColor(inventory, "red");
        System.out.println(redApples);

        List<Apple> heavyWeightApples = filterApplesByWeight(inventory, 150);
        System.out.println(heavyWeightApples);

        List<Apple> greenApples3 = filterApplesUglyWay(inventory, "green", 0, true);
        System.out.println(greenApples3);

        List<Apple> heavyApples2 = filterApplesUglyWay(inventory, "", 150, false);
        System.out.println(heavyApples2);

        List<Apple> greenApples4 = filter(inventory, new AppleGreenColorPredicate());
        System.out.println(greenApples4);

        List<Apple> heavyApples3 = filter(inventory, new AppleHeavyWeightPredicate());
        System.out.println(heavyApples3);

        List<Apple> greenColorHeavyApples = filter(inventory, new AppleGreenColorHeavyWeightPredicate());
        System.out.println(greenColorHeavyApples);

        // Anonymous version

        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
            public boolean test(Apple a){
                return a.getColor().equals("red");
            }
        });
        System.out.println(redApples2);

        // Lambda version

        List<Apple> redApples3 = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(redApples3);

        // Generic Lambda Predicate<T> version with a list of apples

        List<Apple> redApples4 = genericFilter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(redApples4);

        // Generic Lambda Predicate<T> version with a list of integers

        List<Integer> numbers = Arrays.asList(2, 5, 6, 7, 13);
        List<Integer> evenNumbers = genericFilter(numbers, (Integer i) -> i % 2 == 0);
        System.out.println(evenNumbers);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesUglyWay(List<Apple> inventory, String color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }

        return result;
    }

    public static <T> List<T> genericFilter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e : list){
            if(p.test(e)){
                result.add(e);
            }
        }

        return result;
    }

}
