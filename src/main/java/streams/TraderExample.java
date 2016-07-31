package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

public class TraderExample {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(raoul, 2011, 400),
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. Find all the transactions in the year 2011 and sort them by value (small to high)

        List<Transaction> sortedByValue2011Transactions = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        sortedByValue2011Transactions.forEach(System.out::println);
        System.out.println("---------------------");

        // 2. What are the unique cities where the traders work

        List<String> uniqueTraderCities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList()); // we could have used toSet() and remove the distinct() operation

        uniqueTraderCities.forEach(System.out::println);
        System.out.println("---------------------");

        // 3. Find all traders from cambridge and sort them by name

        List<Trader> cambridgeTradersSortedByName = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        cambridgeTradersSortedByName.forEach(System.out::println);
        System.out.println("---------------------");

        // 4. Return a String of all traders' names sorted alphabetically

        String tradersSortedNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (name1, name2) -> name1 + name2); // not efficient, string concatenation. use collect(joining()) which uses stringbuilder

        System.out.println(tradersSortedNames);
        System.out.println("---------------------");

        // 5. Are any traders based in Milan

        boolean anyTraderBasedInMilan = transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));

        System.out.println("Any trader based in Milan : " + anyTraderBasedInMilan);
        System.out.println("---------------------");

        // 6. Print all transactions' values from the traders living in Cambridge

        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .forEach(transaction -> System.out.println(transaction.getValue()));
        System.out.println("---------------------");

        // Or

        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        System.out.println("---------------------");

        // 7. What is the highest value of all transactions

        Optional<Integer> highestTransactionValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        highestTransactionValue.ifPresent(System.out::println);
        System.out.println("---------------------");

        // 8. Find the transaction with the smallest value

        Optional<Transaction> smallestTransaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);

        smallestTransaction.ifPresent(t -> System.out.println("Smallest transaction value : " + t.getValue()));
        System.out.println("---------------------");

        // Or better

        Optional<Transaction> smallestTransaction2 = transactions.stream()
                .min(comparing(Transaction::getValue));

        smallestTransaction2.ifPresent(t -> System.out.println("Smallest transaction value (variant) : " + t.getValue()));
    }

}