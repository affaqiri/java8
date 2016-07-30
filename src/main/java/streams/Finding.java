package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static streams.Dish.menu;

/**
 * Created by ahmad on 01/09/15.
 */
public class Finding {

    public static void main(String[] args) {

        if(isVegetarianFriendlyMenu()){
            System.out.println("Vegetarian friendly");
            System.out.println("---------------------");
        }

        if(isHealthyMenu()){
            System.out.println("Low caloric healthy menu");
            System.out.println("---------------------");
        }

        if(isHealthyMenu2()){
            System.out.println("Low caloric healthy menu 2");
            System.out.println("---------------------");
        }

        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
        System.out.println("---------------------");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
            numbers.stream()
                    .map(x -> x * x)
                    .filter(x -> x % 3 == 0)
                    .findFirst();

        firstSquareDivisibleByThree.ifPresent(n -> System.out.println(n));
    }

    private static boolean isVegetarianFriendlyMenu() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        return menu.stream().allMatch(dish -> dish.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return menu.stream().noneMatch(dish -> dish.getCalories() > 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }

}