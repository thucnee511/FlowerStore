/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Formatter {

    public static String toDateString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date toDate(String date, String format) {
        Date ret = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            ret = sdf.parse(date);
        } catch (ParseException e) {
        }
        return ret;
    }

    public static String toInfoLine(int arg1, String arg2, String arg3, String arg4, int arg5, Double arg6) {
        String total = String.format("$ %.0f", arg6);
        String ret = String.format("|%4d| %-8s | %-10s | %-15s | %12d | %11s |",
                arg1, arg2, arg3, arg4, arg5, total);
        return ret;
    }

    public static String toTotalLine(int count, double total) {
        String _total = String.format("$ %.0f", total);
        String ret = String.format("|    | Total    |                              | %12d | %11s |",count , _total);
        return ret ;
    }
}
