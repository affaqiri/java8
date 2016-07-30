package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static streams.Dish.menu;

/**
 * Created by ahmad on 01/09/15.
 */
public class Reducing {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        System.out.println("---------------------");

        int products = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(products);
        System.out.println("---------------------");

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);
        System.out.println("---------------------");

        Optional<Integer> optionSum = numbers.stream().reduce((a, b) -> a + b);
        optionSum.ifPresent(n -> System.out.println(n));
        System.out.println("---------------------");

        // Not good solution for max because we suppose an initial value of 0 which may impact the final result.
        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);
        System.out.println("---------------------");

        // Better solution with optional but with our own custom predicate function
        Optional<Integer> optionalMax = numbers.stream().reduce((a, b) -> a < b ? b : a);
        optionalMax.ifPresent(n -> System.out.println(n));
        System.out.println("---------------------");

        // Yet better solution with optional
        Optional<Integer> optionalMax2 = numbers.stream().reduce((a, b) -> Integer.max(a, b));
        optionalMax2.ifPresent(n -> System.out.println(n));
        System.out.println("---------------------");

        // Best solution with optional
        Optional<Integer> optionalMax3 = numbers.stream().reduce(Integer::max);
        optionalMax3.ifPresent(n -> System.out.println(n));
        System.out.println("---------------------");

        // Optional min
        Optional<Integer> optionalMin = numbers.stream().reduce(Integer::min);
        optionalMin.ifPresent(n -> System.out.println(n));
        System.out.println("---------------------");

        // Total sum of calories
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories: " + calories);
        System.out.println("---------------------");

        // Number of elements in the menu list
        int numberOfElements = menu.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
        System.out.println("Number of elements: " + numberOfElements);
        System.out.println("---------------------");

        // Number of elements in the menu list using built in functionality
        long numberOfElementsBuiltIn = menu.stream().count();
        System.out.println("Number of elements (built in): " + numberOfElementsBuiltIn);

    }

}