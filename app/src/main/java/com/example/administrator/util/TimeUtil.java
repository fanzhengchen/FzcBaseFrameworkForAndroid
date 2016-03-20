package com.example.administrator.util;

import android.content.Context;

import com.example.administrator.FitConsts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {

    private final static long MS_OF_DAY = 24 * 3600 * 1000;
    public static final int MINUTE = 60 * 1000;

    private final static String[] weekCN = {
            "周日", "周一", "周二", "周三", "周四", "周五", "周六",
    };

    public static String chineseWeek(int dayOfWeek) {
        if (dayOfWeek < 0) {
            dayOfWeek = 0;
        } else if (dayOfWeek >= weekCN.length) {
            dayOfWeek = weekCN.length - 1;
        }
        return weekCN[dayOfWeek];
    }

    /**
     * @return [0, 6]:[周日,周六]
     */
    public static int dayOfWeekToday() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }

    private final static String[] MEAL_EN = {
            FitConsts.BREAKFAST_EN,
            FitConsts.LUNCH_EN,
            FitConsts.DINNER_EN,
            FitConsts.SNACK_EN
    };
    private final static String[] MEAL_CH = {
            FitConsts.BREAKFAST_CH,
            FitConsts.LUNCH_CH,
            FitConsts.DINNER_CH,
            FitConsts.SNACK_CH
    };

    public final static String TIME_BREAKFAST = "6:00-9:30";
    public final static String TIME_LUNCH = "11:00-13:30";
    public final static String TIME_DINNER = "17:00-19:30";

    private static int mealTypeOfNow() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        if (6 == mHour || 7 == mHour || 8 == mHour || (9 == mHour && mMinute <= 30)) {
            return 0;
        } else if (11 == mHour || 12 == mHour || (13 == mHour && mMinute <= 30)) {
            return 1;
        } else if (17 == mHour || 18 == mHour || (19 == mHour && mMinute <= 30)) {
            return 2;
        } else {
            return 3;
        }
    }

    public static String mealEnglishOfNow() {
        return MEAL_EN[mealTypeOfNow()];
    }

    public static String mealStrOfNow() {
        return MEAL_CH[mealTypeOfNow()];
    }

    public static String mealTimeStrOfNow() {

        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        if (6 == mHour || 7 == mHour || 8 == mHour || (9 == mHour && mMinute <= 30)) {
            return TIME_BREAKFAST;
        } else if (11 == mHour || 12 == mHour || (13 == mHour && mMinute <= 30)) {
            return TIME_LUNCH;
        } else if (17 == mHour || 18 == mHour || (19 == mHour && mMinute <= 30)) {
            return TIME_DINNER;
        } else {
            if (0 <= mHour && mHour < 6) {
                return "0:00-6:00";
            }
            if (9 <= mHour && mHour < 11) {
                return "9:30-11:00";
            }
            if (13 <= mHour && mHour < 17) {
                return "13:30-17:00";
            }
            if (19 <= mHour && mHour < 24) {
                return "19:30-24:00";
            }

            return FitConsts.SNACK_CH;
        }
    }

    public static int countPassDay(final String date) {
        return countPassDay(FormatUtil.dateFormString(date), Integer.MAX_VALUE);
    }

    public static int countPassDay(final Date date, final int max) {
        if (new Date().getTime() - date.getTime() > max * MS_OF_DAY) {
            return max;
        }
        final Calendar c1 = Calendar.getInstance();
        c1.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        c1.setTime(new Date());
        int year1 = c1.get(Calendar.YEAR);
        int day1 = c1.get(Calendar.DAY_OF_YEAR);

        final Calendar c2 = Calendar.getInstance();
        c2.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        c2.setTime(date);
        int year2 = c2.get(Calendar.YEAR);
        int day2 = c2.get(Calendar.DAY_OF_YEAR);

        int pass = 0;
        if (year1 == year2) {
            pass = day1 - day2;
        } else {
            pass = 365 - day2 + day1;
        }
        return pass >= 0 ? pass : 0;
    }

    public static int dayOfMonth(final String date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        c.setTime(FormatUtil.dateFormString(date));
        return c.get(Calendar.DAY_OF_MONTH);
    }

    public static int monthOfYear(final String date) {
        return monthOfYear(FormatUtil.dateFormString(date));
    }

    public static int monthOfYear(final Date date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        c.setTime(date);
        return 1 + c.get(Calendar.MONTH);
    }

    public static String friendlyTime(final String date) {
        return friendlyTime(FormatUtil.dateFormString(date));
    }

    public static String friendlyTime(final Date date) {
        switch (TimeUtil.countPassDay(date, 3)) {
            case 0:
                return FormatUtil.formatDate(date, "HH:mm");
            case 1:
                return "昨天 " + FormatUtil.formatDate(date, "HH:mm");
            case 2:
                return "前天 " + FormatUtil.formatDate(date, "HH:mm");
            default:
                return FormatUtil.formatDate(date, "yyyy年MM月dd日 HH:mm");
        }
    }

    @SuppressWarnings("deprecation")
    private static String recentTime(long passed) {
        if (passed < 60 * 1000) {
            return "刚刚";
        }
        passed /= 60 * 1000;
        if (passed < 60) {
            return passed + "分钟前";
        }
        passed /= 60;
        if (passed < 24) {
            return passed + "小时前";
        }
        passed /= 24;
        if (passed < 30) {
            return passed + "天前";
        }
        passed /= 30;
        if (passed < 12) {
            return passed + "个月前";
        }
        return passed / 12 + "年前";
    }

    public static String recentTime(final String date) {
        return recentTime(System.currentTimeMillis() - FormatUtil.msOfTime(date));
    }

    public static boolean isToday(String date) {
        return null != date && date.startsWith(FormatUtil.getDateString(FitConsts.DATE_FORMAT));
    }

    public static int countWeekFrom(String startDate) {
        final Calendar c1 = Calendar.getInstance();
        c1.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        c1.setTime(new Date());
        int year1 = c1.get(Calendar.YEAR);
        int week1 = c1.get(Calendar.WEEK_OF_YEAR);

        final Calendar c2 = Calendar.getInstance();
        c2.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        c2.setTime(FormatUtil.dateFormString(startDate));
        int year2 = c2.get(Calendar.YEAR);
        int week2 = c2.get(Calendar.WEEK_OF_YEAR);

        int pass = 0;
        if (year1 == year2) {
            pass = week1 - week2;
        } else {
            pass = 52 - week2 + week1;
        }
        return pass >= 0 ? pass : 0;
    }

    public static String getCurrentTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sDateFormat.format(new Date());
        return date;
    }
}
