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
        //get current date
        //date is always in current timezone
        Date now = new Date();
        System.out.println("Now is " + now);
        Date zero = new Date(0);
        System.out.println("Zero with current timezone is " + zero);
        Calendar anotherNow = Calendar.getInstance();

        System.out.println("Now calendar is " + anotherNow);
        System.out.println("Now to date " + anotherNow.getTime());
        System.out.println("Now in millis. " + anotherNow.getTimeInMillis());
        //todo date in another timezone

        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date parsedDate = format.parse("20.02.1984");
        System.out.println("Parsed date from date format" + parsedDate);
        System.out.println("Printed today in date format " + format.format(now));
        //бегаем по датам
        anotherNow.add(Calendar.DAY_OF_MONTH, 12);
        anotherNow.add(Calendar.MINUTE, 30);
        System.out.println("Added time "+anotherNow.getTime());
        //deprecated
        System.out.println("Deprecated minutes" + now.getMinutes());
        //correct
        anotherNow.setTime(now);
        System.out.println("Correct minutes "+anotherNow.get(Calendar.MINUTE));
        //работаем с таймзонами
        Calendar nowInNewYork = Calendar.getInstance(
                TimeZone.getTimeZone("America/New_York"), new Locale("en", "US"));
        System.out.println("Hour in america: " + nowInNewYork.get(Calendar.HOUR_OF_DAY));

        //convert full date
        SimpleDateFormat sdfAmerica = new SimpleDateFormat();
        TimeZone tzInAmerica = TimeZone.getTimeZone("America/New_York");
        sdfAmerica.setTimeZone(tzInAmerica);

        String sDateInAmerica = sdfAmerica.format(now); // Convert to String first
        Date dateInAmerica = sdfAmerica.parse(sDateInAmerica); // Create a new Date object

        System.out.println("TimeZone : " + tzInAmerica.getID() + " - " + tzInAmerica.getDisplayName());
        System.out.println("TimeZone : " + tzInAmerica);
        System.out.println("Date (New York) (String) : " + sDateInAmerica);
        System.out.println("Date (New York) (Object) : " + sdfAmerica.format(dateInAmerica));
    }
}
