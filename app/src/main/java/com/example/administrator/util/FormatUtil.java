package com.example.administrator.util;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.administrator.FitConsts;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dylan.zhao
 * @ClassName: FormatUtil
 * @Description: 单位转换和格式化工具
 */
public class FormatUtil {

    public static int pixOfDip(final float dip) {
        return Math.round(dip * getDisplayMetrics().density);
    }

    public static int pixOfSp(final float sp) {
        return Math.round(sp * getDisplayMetrics().scaledDensity);
    }

    private static DisplayMetrics getDisplayMetrics() {
        return Resources.getSystem().getDisplayMetrics();
    }

    public static String formatMoney(final float money) {
        return new DecimalFormat("#,###.##").format(money);
    }

    public static String formatMoney(final int money) {
        return new DecimalFormat("#,###").format(money);
    }

    /**
     * 日期格式化
     */
    @SuppressLint("SimpleDateFormat")
    public static String getDateString() {
        return getDateString(FitConsts.DATE_TIME_FORMAT);
    }

    public static String getDateString(final String format) {
        return formatDate(new Date(), format);
    }

    public static String formatTime(final long t) {
        if (t < 0) {
            return null;
        } else {
            return new SimpleDateFormat(FitConsts.DATE_TIME_FORMAT)
                    .format(new Date(t));
        }
    }

    public static String formatDate(final Date date) {
        return formatDate(date, FitConsts.DATE_TIME_FORMAT);
    }

    public static String formatDate(final Date date, final String format) {
        if (null == date) {
            return "";
        } else {
            return new SimpleDateFormat(format).format(date);
        }
    }

    public static String moneyNotNull(final String money) {
        return money != null ? money : "0.00";
    }

    public static Date dateFormString(final String timeStr, final String format) {
        if (null != timeStr) {
            try {
                return new SimpleDateFormat(format).parse(timeStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Date();
    }

    public static Date dateFormString(final String timeStr) {
        if (null != timeStr) {
            String format = FitConsts.DATE_FORMAT;
            if (timeStr.contains(" ") && timeStr.contains(":")) {
                format = FitConsts.DATE_TIME_FORMAT;
            }
            return dateFormString(timeStr, format);
        }
        return new Date();
    }

    public static long msOfTime(final String time) {
        try {
            return new SimpleDateFormat(FitConsts.DATE_TIME_FORMAT).parse(time).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int parseDaysFrom(final String time) {
        return (int) ((System.currentTimeMillis() - msOfTime(time)) / (24 * 3600 * 1000));
    }

    public static String convertDate(final String dateStr, final String fromFormat, final String toFormat) {
        Date date = null;
        try {
            date = new SimpleDateFormat(fromFormat).parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDate(date, toFormat);
    }
}
