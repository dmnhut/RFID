package model;

/**
 *
 * @author Dev
 */
import java.text.SimpleDateFormat;

public class Date {

    java.util.Date date;
    String dateFormat = "dd/MM/yyyy";
    String timeFormat = "HH:mm:ss";
    String timeAndDate = "dd/MM/yyyy HH:mm:ss";

    public Date() {
        date = new java.util.Date();
    }

    public String getTimeAndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(timeAndDate);
        return sdf.format(date);
    }

    public String getDate(String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    public String getTime(String timeFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
        return sdf.format(date);
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
        return sdf.format(date);
    }

    public static void main(String[] args) {
        Date d = new Date();
    }
}
