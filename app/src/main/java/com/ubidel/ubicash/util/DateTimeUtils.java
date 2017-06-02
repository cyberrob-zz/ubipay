package com.ubidel.ubicash.util;

import android.content.Context;
import net.danlew.android.joda.DateUtils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by bowenwang on 2017/6/2.
 */

public class DateTimeUtils {

    //public static SimpleDateFormat defaultFormatter = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
    public static DateTimeFormatter defaultFormatter = DateTimeFormat.forPattern("yyyy-mm-dd-T-hh:mm:ss");
    //public static DateTimeFormatter locationUpdateTimeFormatter = DateTimeFormat.forPattern("E MMM dd, yyyy - HH:mma");

    public static String getDifference(Context context, long timestamp) {
//        if (timestamp == 0L) {
//            return context.getString(R.string.text_now);
//        } else {
            DateTime theDateTime = new DateTime(timestamp);
            return String.valueOf(DateUtils.getRelativeTimeSpanString(context, theDateTime, DateUtils.FORMAT_ABBREV_ALL));
//        }
    }

    public static String getFormattedDateString(long timestamp) {
        DateTime dateTime = new DateTime(timestamp);
        return dateTime.toString(defaultFormatter);
    }

//    public static String getFormattedUpdateTime(long timestamp) {
//        DateTime dateTime = new DateTime(timestamp);
//        return dateTime.toString(locationUpdateTimeFormatter);
//    }
}
