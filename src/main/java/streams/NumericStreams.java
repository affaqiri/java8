package streams;

import java.util.stream.*;
import java.util.*;

import static streams.Dish.menu;

public class NumericStreams {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        Arrays.stream(numbers.toArray()).forEach(System.out::println);
        System.out.println("---------------------");

        // Conversion of a Stream<T> to IntStream supporting sum, max, min, etc.

        int totalCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        System.out.println("Total number of calories : " + totalCalories);
        System.out.println("---------------------");

        // Conversion back from an IntSteam to the boxed Stream<Integer>

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);

        intStream.forEach(System.out::println);
        System.out.println("---------------------");

        Stream<Integer> boxedIntStream = menu.stream().mapToInt(Dish::getCalories).boxed();

        boxedIntStream.forEach(System.out::println);
        System.out.println("---------------------");

        // Optional variant for numeric values

        OptionalInt optionalMaxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int maxCalorie = optionalMaxCalories.orElse(1);

        System.out.println("Max calorie : " + maxCalorie);
        System.out.println("---------------------");

        // Numeric ranges with IntStream static methods : range and rangeClosed

        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);

        System.out.println("Total even numbers from 1 to 100 : " + evenNumbers.count());
        System.out.println("---------------------");




    }



}
