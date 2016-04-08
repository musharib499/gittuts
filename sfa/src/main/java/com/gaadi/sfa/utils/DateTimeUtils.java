package com.gaadi.sfa.utils;

import java.io.StringWriter;
import java.text.SimpleDateFormat;

/**
 * Created by vinodtakhar on 18/2/16.
 */
public class DateTimeUtils {
    public static String getFormattedDateTime(String date){
        if(date==null || date.isEmpty())return "";
        else
        return new SimpleDateFormat("EEE, MMM dd, yyyy hh:mm a").format(Long.parseLong(date));
    }
    public static String getFormattedDate(String date){
        if(date==null || date.isEmpty())return "";
        else
        return new SimpleDateFormat("EEE, MMM dd, yyyy").format(Long.parseLong(date));
    }
    public static String getFormattedTime(String date){
        if(date==null || date.isEmpty())return "";
        else
        return new SimpleDateFormat("hh:mm a").format(Long.parseLong(date));
    }
}
