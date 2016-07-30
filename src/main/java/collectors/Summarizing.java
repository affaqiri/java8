package collectors;

import streams.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;

import static java.util.stream.Collectors.*;
import static streams.Dish.menu;

/**
 * Created by ahmad on 08/10/15.
 */
public class Summarizing {

    public static void main(String[] args) {

        System.out.println("Nr. of dishes : " + howManyDishes());

        if (findMostCaloricDishUsingComparator().isPresent()) {
            System.out.println("The most caloric dish is : " + findMostCaloricDishUsingComparator().get());
        }

        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());

        if (findMostCaloricDishWithReduce().isPresent()) {
            System.out.println("The most caloric dish is : " + findMostCaloricDishWithReduce().get());
        }

    }

    private static long howManyDishes() {
        return menu.stream().collect(counting());
        //or menu.stream().count();
    }

    private static Optional<Dish> findMostCaloricDishWithReduce() {
        return menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
    }

    private static Optional<Dish> findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        return menu.stream().collect(maxBy(dishCaloriesComparator));
    }

    private static int calculateTotalCalories() {
        return menu.stream().collect(summingInt(Dish::getCalories));
    }

    private static Double calculateAverageCalories() {
        return menu.stream().collect(averagingInt(Dish::getCalories));
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        return menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    private static String getShortMenu() {
        return menu.stream().map(Dish::getName).collect(joining());
    }

    private static String getShortMenuCommaSeparated() {
        return menu.stream().map(Dish::getName).collect(joining(", "));
    }

//    private static int calculateTotalCaloriesUsingReducing() {
//        return menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
//    }

}