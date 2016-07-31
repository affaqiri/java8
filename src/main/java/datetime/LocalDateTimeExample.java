package datetime;

import java.time.*;
import java.time.temporal.ChronoField;

public class LocalDateTimeExample {

    public static void main(String[] args) {

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        System.out.println("Date Time 1 : " + dt1);

        LocalDate date = LocalDate.of(2014, 3, 18);
        LocalTime time = LocalTime.of(13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        System.out.println("Date Time 2 : " + dt2);

        LocalDateTime dt3 = date.atTime(13, 45, 20);
        System.out.println("Date Time 3 : " + dt3);

        LocalDateTime dt4 = date.atTime(time);
        System.out.println("Date Time 4 : " + dt4);

        LocalDateTime dt5 = time.atDate(date);
        System.out.println("Date Time 5 : " + dt5);

        System.out.println("---------------------");

        LocalDate datePart = dt5.toLocalDate();
        System.out.println("Date Part : " + datePart);

        System.out.println("---------------------");

        LocalTime timePart = dt5.toLocalTime();
        System.out.println("Time Part : " + timePart);

    }

}