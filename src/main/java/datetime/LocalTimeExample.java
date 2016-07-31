package datetime;

import java.time.LocalTime;

public class LocalTimeExample {

    public static void main(String[] args) {

        LocalTime time = LocalTime.of(13, 45, 20);
        System.out.println("Time : " + time);

        System.out.println("---------------------");

        int hour = time.getHour();
        System.out.println("Hour : " + hour);

        System.out.println("---------------------");

        int minute = time.getMinute();
        System.out.println("Minute : " + minute);

        System.out.println("---------------------");

        int second = time.getSecond();
        System.out.println("Second : " + second);

        System.out.println("---------------------");

        LocalTime parsedTime = LocalTime.parse("20:21:22");
        System.out.println("Parsed Time : " + parsedTime);

    }

}