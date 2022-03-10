package dates;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateAPI {
    private int year, month, day;

    DateAPI(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    boolean isLeapYear() {
        // 2012 -> 2016 -> 2020 -> 2024
        if (year % 4 == 0 ) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }

            return true;
        }

        return false;
    }

    int getCentury() {
        int century = this.year / 100;

        if (this.year % 10 == 0)
            return century;

        return century + 1;

        // return (this.year + 99) / 100;
    }

    int getDaysDifference(DateAPI other) {
        // approach -> transform both dates to seconds passed and subtract them
        Calendar firstCal = Calendar.getInstance();
        firstCal.set(Calendar.DAY_OF_MONTH, this.day);
        firstCal.set(Calendar.MONTH, this.month);
        firstCal.set(Calendar.YEAR, this.year);

        Date firstDate = firstCal.getTime(); // milliseconds

        Calendar secondCal = Calendar.getInstance();
        secondCal.set(Calendar.DAY_OF_MONTH, other.day);
        secondCal.set(Calendar.MONTH, other.month);
        secondCal.set(Calendar.YEAR, other.year);

        Date secondDate = secondCal.getTime(); // milliseconds
        long milliseconds = Math.abs(firstDate.getTime() - secondDate.getTime());
        return (int) (milliseconds / (1000*60*60*24));
    }

    public static void main(String[] args) {
        DateAPI date2 = new DateAPI(2000, 9, 2);
        DateAPI date = new DateAPI(2000, 10, 10);
        System.out.println(date.getCentury());
        System.out.println(date.isLeapYear());

        System.out.printf("Day difference is: %d days", date.getDaysDifference(date2));
    }
}
