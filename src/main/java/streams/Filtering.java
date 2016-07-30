package streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

import static streams.Dish.menu;

/**
 * Created by ahmad on 01/09/15.
 */
public class Filtering {

    public static void main(String[] args) {

        //Filtering with predicate

        List<Dish> vegetarianMenu =
            menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        vegetarianMenu.forEach(System.out::println);
        System.out.println("---------------------");

        // Filtering unique elements

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        System.out.println("---------------------");

        // Truncating a stream

        List<Dish> dishesLimit3 =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());

        dishesLimit3.forEach(System.out::println);
        System.out.println("---------------------");

        // Skipping elements

        List<Dish> dishesSkip2 =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());

        dishesSkip2.forEach(System.out::println);
        System.out.println("---------------------");

        List<Dish> firstTwoMeatDishes =
            menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());

        firstTwoMeatDishes.forEach(System.out::println);
        System.out.println("---------------------");
    }

}