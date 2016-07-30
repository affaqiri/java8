package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * Created by ahmad on 02/10/15.
 */
public class LocalDateExample {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2014, 3, 18);
        System.out.println("Date : " + date);

        System.out.println("---------------------");

        int year = date.getYear();
        System.out.println("Year : " + year);
        int getYear = date.get(ChronoField.YEAR);
        System.out.println("Year : " + getYear);

        System.out.println("---------------------");

        Month month = date.getMonth();
        System.out.println("Month : " + month);
        int getMonth = date.get(ChronoField.MONTH_OF_YEAR);
        System.out.println("Month : " + getMonth);

        System.out.println("---------------------");

        int dayOfMonth = date.getDayOfMonth();
        System.out.println("Day of month : " + dayOfMonth);
        int getDayOfMonth = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println("Day of month : " + getDayOfMonth);

        System.out.println("---------------------");

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println("Day of week : " + dayOfWeek);

        int lengthOfMonth = date.lengthOfMonth();
        System.out.println("Length of month : " + lengthOfMonth);

        boolean isLeapYear = date.isLeapYear();
        System.out.println("Is leap year : " + isLeapYear);

        System.out.println("---------------------");

        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date : " + currentDate);

        System.out.println("---------------------");

        LocalDate parsedDate = LocalDate.parse("2014-03-18");
        System.out.println("Parsed Date : " + parsedDate);

    }

}