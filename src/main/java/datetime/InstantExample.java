package datetime;

import java.time.Instant;

/**
 * Created by ahmad on 02/10/15.
 */
public class InstantExample {

    public static void main(String[] args) {

        Instant instant1 = Instant.ofEpochSecond(3);
        System.out.println("3 seconds passed 1970-01-01 00:00:00 : " + instant1);

        Instant instant2 = Instant.ofEpochSecond(3, 0);
        System.out.println("3 seconds and 0 nanosecond passed 1970-01-01 00:00:00 : " + instant2);

        Instant instant3 = Instant.ofEpochSecond(2, 1_000_000_000);
        System.out.println("2 seconds plus one billion nanoseconds passed 1970-01-01 00:00:00 (= 3 seconds) : " + instant3);

        Instant instant4 = Instant.ofEpochSecond(4, -1_000_000_000);
        System.out.println("4 seconds minus one billion nanoseconds passed 1970-01-01 00:00:00 (= 3 seconds) : " + instant4);

        System.out.println("---------------------");

        Instant instant5 = Instant.ofEpochSecond(3, 100);
        System.out.println("3 seconds plus 100 nanoseconds passed 1970-01-01 00:00:00 : " + instant5);

    }

}