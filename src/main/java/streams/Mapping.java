package streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

import static streams.Dish.menu;

/**
 * Created by ahmad on 01/09/15.
 */
public class Mapping {

    public static void main(String[] args) {

        List<String> dishNames =
            menu.stream()
                .map(Dish::getName)
                .collect(toList());

        dishNames.forEach(System.out::println);
        System.out.println("---------------------");

        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordsLength =
            words.stream()
                 .map(String::length)
                 .collect(toList());

        wordsLength.forEach(System.out::println);
        System.out.println("---------------------");

        // Length of the name of each dish
        List<Integer> dishNameLengths =
            menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        dishNameLengths.forEach(System.out::println);
        System.out.println("---------------------");

        // Flat map

        List<String> uniqueCharacters =
            words.stream()
                 .map(word -> word.split(""))
                 .flatMap(Arrays::stream)
                 .distinct()
                 .collect(toList());

        uniqueCharacters.forEach(System.out::println);
        System.out.println("---------------------");

        //Square of numbers

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> squares =
            numbers.stream()
                    .map(n -> n * n)
                    .collect(toList());

        squares.forEach(System.out::println);
        System.out.println("---------------------");

        // Pair of integers

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int []> pairs =
            numbers1.stream()
                    .flatMap(i -> numbers2.stream()
                                          .map(j -> new int[] {i, j}))
                    .collect(toList());

        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
        System.out.println("---------------------");

        // Pair of integers with a filter

        List<int []> filteredPairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                              .filter(j -> (i + j) % 3 == 0)
                                              .map(j -> new int[]     {i, j}))
                        .collect(toList());

        filteredPairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
        System.out.println("---------------------");
    }

}