package net.punklan.glorfindeil.study.lesson3;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import static java.time.DayOfWeek.WEDNESDAY;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

/**
 * Created by glorfindeil on 07.03.17.
 */
public class DateJava8Example {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now(
        ));     // The current date and time
        System.out.println(LocalDate.of(2012, Month.DECEMBER, 12)); // from values
        System.out.println(LocalDate.ofEpochDay(150));  // middle of 1970
        System.out.println(LocalTime.of(17, 18)); // the train I took home today
        System.out.println(LocalTime.parse("10:15:30")); // From a String


        //бегаем по датам
        System.out.println(LocalDateTime.now().plusHours(10));
        System.out.println(LocalDateTime.now().plus(10, MINUTES));
        LocalDateTime timePoint = LocalDateTime.now();
        System.out.println(timePoint.with(lastDayOfMonth()));
        System.out.println(timePoint.with(previousOrSame(WEDNESDAY)));

        //timezones
        //current date with another zone
        ZoneId id = ZoneId.of("Europe/Paris");
        ZonedDateTime zoned = ZonedDateTime.of(LocalDateTime.now(), id);
        System.out.println("zoned = " + zoned);

        zoned = ZonedDateTime.now().withZoneSameInstant(id);
        System.out.println("Now in Paris " + zoned);
        //Instant
        Instant now = Instant.now();
        LocalDateTime ldt = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.printf("%s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(),
                ldt.getYear(), ldt.getHour(), ldt.getMinute());
        //comparing
        System.out.println(now.isBefore(timePoint.toInstant(ZoneOffset.ofHours(3))));
    }


}
