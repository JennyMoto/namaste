package util;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtil {
    public static Timestamp getTimestampFromDate(int year, int month, int day) {
        return new Timestamp(new GregorianCalendar(year, month - 1, day).getTime().getTime());
    }

    public static Timestamp getTimestampFromCalendar(Calendar date) {
        return new Timestamp(date.getTime().getTime());
    }

    public static Calendar getCalendarFromTimestamp(Timestamp date) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTimeInMillis(date.getTime());
        return calendarDate;
    }

    public static Timestamp getNearestMondayToDate(Timestamp date) {
        return getTimestampFromCalendar(getNearestMondayToDate(getCalendarFromTimestamp(date)));
    }

    public static Calendar getNearestMondayToDate(Calendar date) {
        Calendar monday = (Calendar) date.clone();

        int dayOfWeek = monday.get(Calendar.DAY_OF_WEEK);
        int daysSinceMonday = Calendar.MONDAY - dayOfWeek;

        if (dayOfWeek != Calendar.SUNDAY) {
            monday.add(Calendar.DATE, daysSinceMonday);
        } else {
            monday.add(Calendar.DATE, -6);
        }

//        System.out.printf("%d %d %d \n",
//                monday.get(Calendar.YEAR),
//                monday.get(Calendar.MONTH),
//                monday.get(Calendar.DAY_OF_MONTH));
        return monday;
    }
    
}
