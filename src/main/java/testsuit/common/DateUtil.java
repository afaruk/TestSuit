package testsuit.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static String DATE_FORMAT = "dd:MM:yy-HH:mm:ss:SSSS";

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static String convertToDate(long milliSecond) {
        Date date = new Date(milliSecond);
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(date);
    }
}
