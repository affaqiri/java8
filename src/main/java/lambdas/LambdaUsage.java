package lambdas;

import behaviorparameterization.Apple;

import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by ahmad on 06/10/15.
 */
public class LambdaUsage {

    public static void main(String[] args) {

        // Comparator with Lambda

        Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        // Runnable with Lambda

        Runnable r1 = () -> System.out.println("Hello World");
        r1.run();
        process(r1);
        process(() -> System.out.println("Hello World Again"));

        // Primitive functional interfaces

        // No boxing
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        System.out.println("1000 is an even number : " + evenNumbers.test(1000));

        // With boxing (generic), require memory and less performant than above
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        System.out.println("1000 is an odd number : " + oddNumbers.test(1000));

    }

    public static void process(Runnable r) {
        r.run();
    }

}