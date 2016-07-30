package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by ahmad on 07/10/15.
 */
public class FunctionUsage {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("lambdas", "in", "action");
        words.forEach(System.out::println);

        System.out.println("Length of words : ");

        List<Integer> wordLengths = map(words, (String s) -> s.length());
        wordLengths.forEach(System.out::println);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s: list) {
            result.add(f.apply(s));
        }
        return result;
    }

}