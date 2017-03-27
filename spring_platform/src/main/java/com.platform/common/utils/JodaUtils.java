package com.platform.common.utils;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

/**
 * Created by tanghong on 2017/2/21.
 */
public class JodaUtils {

    private static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
    private static final String PATTERN_LOCAL_DATE = "yyyy-MM-dd";

    private static DateTimeFormatterBuilder getFormatterBuilder(String format){
        return new DateTimeFormatterBuilder().appendPattern(format);
    }

    public static String getDateTime(){
        return DateTime.now().toString(PATTERN_DATETIME);
    }

    public static String getDate() {
        return LocalDate.now().toString(PATTERN_LOCAL_DATE);
    }

    public static DateTime dateTimeParse(String time){
        return DateTime.parse(
            time,
            new DateTimeFormatter(null, getFormatterBuilder(PATTERN_DATETIME).toParser())
        );
    }

    public static LocalDate LocalDateParse(String time){
        return LocalDate.parse(
            time,
            new DateTimeFormatter(null, getFormatterBuilder(PATTERN_LOCAL_DATE).toParser())
        );
    }
}
