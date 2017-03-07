package net.punklan.glorfindeil.study.lesson3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by glorfindeil on 07.03.17.
 */
public class DateExample {
    public static void main(String[] args) throws ParseException {
        Date now = new Date();
        Calendar anotherNow = Calendar.getInstance();
        System.out.println(now);
        System.out.println(anotherNow);
        System.out.println(anotherNow.getTime());
        System.out.println(anotherNow.getTimeInMillis());
        //todo date in another timezone
        //работаем с таймзонами
        Calendar nowInNewYork = Calendar.getInstance(
                TimeZone.getTimeZone("New York"), new Locale("en", "US"));
        System.out.println(nowInNewYork.getTime());
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date parsedDate = format.parse("20.02.1984");
        System.out.println(parsedDate);
        System.out.println(format.format(now));
        //бегаем
        anotherNow.add(Calendar.DAY_OF_MONTH, 12);
        anotherNow.add(Calendar.MINUTE, 30);
        System.out.println(anotherNow.getTime());
        System.out.println(now.getMinutes());
        anotherNow.setTime(now);
        System.out.println(anotherNow.get(Calendar.MINUTE));
    }
}
