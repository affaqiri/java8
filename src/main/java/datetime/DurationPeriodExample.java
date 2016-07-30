package datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by ahmad on 02/10/15.
 */
public class DurationPeriodExample {

    public static void main(String[] args) {

        LocalTime time1 = LocalTime.of(14,00,00);
        System.out.println("Time 1 : " + time1);

        LocalTime time2 = LocalTime.of(15,30,30);
        System.out.println("Time 2 : " + time2);

        Duration d1 = Duration.between(time1, time2);
        System.out.println("Duration between time 1 and time 2 : " + d1);

        System.out.println("---------------------");

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        System.out.println("Date Time 1 : " + dt1);

        LocalDateTime dt2 = LocalDateTime.of(2014, Month.APRIL, 18, 13, 45, 20);
        System.out.println("Date Time 2 : " + dt2);

        Duration d2 = Duration.between(dt1, dt2);
        System.out.println("Duration between date time 1 and date time 2 : " + d2);

        System.out.println("---------------------");

        Instant instant1 = Instant.ofEpochSecond(3);
        System.out.println("3 seconds passed 1970-01-01 00:00:00 : " + instant1);

        Instant instant2 = Instant.ofEpochSecond(3000);
        System.out.println("3000 seconds passed 1970-01-01 00:00:00 : " + instant2);

        Duration d3 = Duration.between(instant1, instant2);
        System.out.println("Duration between instant 1 and instant 2 : " + d3);

        System.out.println("---------------------");

        LocalDate date1 = LocalDate.of(2014, 3, 8);
        System.out.println("Date 1 : " + date1);

        LocalDate date2 = LocalDate.of(2015, 4, 18);
        System.out.println("Date 2 : " + date2);

        Period period = Period.between(date1, date2);
        System.out.println("Period between date 1 and date 2 : " + period);

        System.out.println("---------------------");

        Duration threeMinutesDuration1 = Duration.ofMinutes(3);
        System.out.println("3 Minutes Duration : " + threeMinutesDuration1);

        Duration threeMinutesDuration2 = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println("3 Minutes Duration : " + threeMinutesDuration2);

        System.out.println("---------------------");

        Period tenDaysPeriod = Period.ofDays(10);
        System.out.println("10 Days Period : " + tenDaysPeriod);

        Period threeWeeksPeriod = Period.ofWeeks(3);
        System.out.println("3 Weeks Period : " + threeWeeksPeriod);

        Period twoYearsSixMonthsOneDayPeriod = Period.of(2, 6, 1);
        System.out.println("Two years six months and one day period : " + twoYearsSixMonthsOneDayPeriod);

    }

}