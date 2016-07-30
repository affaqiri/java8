package lambdas;

import behaviorparameterization.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.List;

/**
 * Created by ahmad on 07/10/15.
 */
public class Sorting {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")));

        // First attempt : anonymous class comparator

        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(2, new Apple(30, "red"));

        // Second attempt : inline anonymous comparator

        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(20, "red"));

        // Third attempt : lambda expression comparator

        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(10, "red"));

        // Fourth attempt : method reference comparator
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);

        // Without method reference
        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.forEach(System.out::println);

        // With method reference
        str.sort(String::compareToIgnoreCase);
        str.forEach(System.out::println);
    }

    static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }

}