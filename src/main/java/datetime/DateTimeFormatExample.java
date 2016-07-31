package datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class DateTimeFormatExample {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);

        // Format date to a string
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("BASIC_ISO_DATE : " + s1);

        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("ISO_LOCAL_DATE : " + s2);

        // Parse a string to a date
        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("Date1 : " + date1);

        LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("Date2 : " + date2);

        // Specific pattern without local
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Formatted Date : " + date.format(formatter));
        System.out.println("Date : " + LocalDate.parse(date.format(formatter), formatter));

        // Specific pattern with local
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        System.out.println("Formatted Date : " + date.format(italianFormatter));
        System.out.println("Date : " + LocalDate.parse(date.format(italianFormatter), italianFormatter));

        DateTimeFormatter complexFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);

        System.out.println(date.format(complexFormatter));
    }

}