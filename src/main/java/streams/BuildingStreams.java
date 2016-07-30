package streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreams {

    public static void main(String[] args) {

        // Streams from values

        Stream<String> streamOfValues = Stream.of("Java 8", "Lambda", "In", "Action");
        streamOfValues.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();

        System.out.println("---------------------");

        // Streams from arrays

        int[] numbers = {2, 3, 5, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("Sum : " + sum);

        System.out.println("---------------------");

        // Streams from files

        long uniqueWords = 0;
        //TODO create the example

        System.out.println("---------------------");

        // Streams from functions: creating infinite streams

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("---------------------");

        // Fibonacci tuples series

        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        System.out.println("---------------------");

        // Fibonacci series

        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);

        System.out.println("---------------------");

        // Generate

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

    }

}