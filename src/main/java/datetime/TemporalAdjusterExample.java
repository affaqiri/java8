package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.*;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.firstDayOfNextMonth;

public class TemporalAdjusterExample {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2014, 3, 18);
        System.out.println("Date : " + date);

        date = date.with(nextOrSame(DayOfWeek.SUNDAY)); // the original date object is immutable so need to assign the returned object to another object.
        System.out.println("Date : " + date);

        date = date.with(lastDayOfMonth());
        System.out.println("Date : " + date);

        date = date.with(firstDayOfNextMonth());
        System.out.println("Date : " + date);

        // Custom Temporal Adjuster usage
        date = date.with(new NextWorkingDay());
        System.out.println("Date : " + date);
        date = date.with(nextOrSame(DayOfWeek.FRIDAY));
        System.out.println("Date : " + date);
        date = date.with(new NextWorkingDay());
        System.out.println("Date : " + date);

        // Lambda style custom temporal adjuster
        /*
        date = date.with(nextOrSame(DayOfWeek.FRIDAY));
        System.out.println("Date : " + date);

        date = date.with(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;

            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        System.out.println("Date : " + date);
        */

        // Preferred method for lambdas
        date = date.with(nextOrSame(DayOfWeek.FRIDAY));
        System.out.println("Date : " + date);

        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;

            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });

        date = date.with(nextWorkingDay);
        System.out.println("Date : " + date);

    }

    /**
     * Custom Temporal Adjuster
     */
    private static class NextWorkingDay implements TemporalAdjuster {
        @Override
        public Temporal adjustInto(Temporal temporal) {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            }
            if (dow == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }

            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        }
    }
}
