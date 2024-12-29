package net.csibio.labic.utils;

import cn.hutool.core.date.DateUtil;
import net.csibio.labic.constants.SymbolConst;
import org.springframework.util.ObjectUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 *
 * @author 顾遥
 */
public class DateUtils {
    public static final long DAY_LONG = 86400000;
    public static final long DAY_SECOND = 86400;
    public static final long HOUR_LONG = 3600000;
    public static final long HOUR_SECOND = 3600;
    public static final long MINUTE_LONG = 60000;
    public static final long MINUTE_SECOND = 60;
    public static final long SECOND_LONG = 1000;
    public static final String DATA_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String HOUR_STR = "小时";
    public static final String MINUTE_STR = "分钟";
    public static final String SECOND_STR = "秒";
    public static final int WEEK_DAYS = 7;
    public static final String DATA_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATA_TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";
    public static final String ADAPT_OFFSET = "+8";
    public static final long MINUTE_SECOND_LONG = 60;

    public static LocalDateTime dateHourAdd(Date date, int hours) {
        Date date1 = DateUtil.offsetHour(date, hours).toJdkDate();
        Instant instant = date1.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    public static LocalDateTime dateHourAdd(LocalDateTime date, int hours) {
        return date.plus(hours, java.time.temporal.ChronoUnit.HOURS);

    }

    /**
     * @param dateStr
     * @return
     */
    public static boolean isValid(String dateStr) {
        return isValid(dateStr, DATA_FORMAT);
    }

    /**
     * @param dateStr
     * @return
     */
    public static boolean isValidLaterNow(String dateStr) {
        return isValidLaterNow(dateStr, DATA_FORMAT);
    }

    /**
     * @param dateStr
     * @return
     */
    public static boolean isValidLaterNow(String dateStr, String formatType) {
        final DateFormat sdf = new SimpleDateFormat(formatType);
        sdf.setLenient(false);
        try {
            Date parse = sdf.parse(dateStr);
            return parse.getTime() <= System.currentTimeMillis();
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * @param dateStr
     * @return
     */
    public static boolean isValid(String dateStr, String formatType) {
        final DateFormat sdf = new SimpleDateFormat(formatType);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * @param dateStrs
     * @return
     */
    public static boolean isValid(String[] dateStrs, String formatType) {
        final DateFormat sdf = new SimpleDateFormat(formatType);
        sdf.setLenient(false);
        try {
            for (String dateStr : dateStrs) {
                sdf.parse(dateStr);
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 时间比较
     *
     * @param itemDate1
     * @param itemDate2
     * @param splitFlag 分隔符
     * @return
     */
    public static boolean getTimeSort(String itemDate1, String itemDate2, String splitFlag) {
        String[] itemStr1 = itemDate1.split(splitFlag);
        String[] itemStr2 = itemDate2.split(splitFlag);
        for (int i = 0; i < itemStr1.length; i++) {
            if (Long.parseLong(itemStr1[i]) > Long.parseLong(itemStr2[i])) {
                return true;
            } else if (Long.parseLong(itemStr1[i]) < Long.parseLong(itemStr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static String nowStr(String formatType) {
        final DateFormat sdf = new SimpleDateFormat(formatType);
        return sdf.format(new Date());
    }

    public static String nowStr() {
        return nowStr(DATA_FORMAT);
    }

    public static String getTimeByStr(String studyTime, String formatType) {
        final DateFormat sdf = new SimpleDateFormat(formatType);
        try {
            Date parse = sdf.parse(studyTime);
            return "" + parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getTimeByStr(String studyTime) {
        return getTimeByStr(studyTime, DATA_FORMAT);

    }

    public static LocalDateTime getLocalDateTimeByDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    public static LocalDateTime getLocalDateTimeByStr(String strDateTime) {
        if (ObjectUtils.isEmpty(strDateTime)) {
            return null;
        }
        return strDateTime.contains(SymbolConst.T) ? LocalDateTime.parse(strDateTime) : LocalDateTime.parse(strDateTime, DateTimeFormatter.ofPattern(DateUtils.DATA_TIME_FORMAT));
    }

    public static long getSeconds(int day, int hour, int minute, int second) {
        return (day * DAY_LONG + hour * HOUR_LONG + minute * MINUTE_LONG + second * SECOND_LONG) / SECOND_LONG;
    }

    public static int getWeekNum(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
                return 1;
            case TUESDAY:
                return 2;
            case WEDNESDAY:
                return 3;
            case THURSDAY:
                return 4;
            case FRIDAY:
                return 5;
            case SATURDAY:
                return 6;
            case SUNDAY:
                return 0;
            default:
                return 0;
        }
    }

    public static String getNowDateTimeCN() {
        return DateUtil.format(new Date(), DATA_TIME_FORMAT_CN);
    }


    public static List<LocalDateTime> adaptList(List<LocalDateTime> startAndEndTime) {
        List<LocalDateTime> localDateTimes = new ArrayList<>();
        for (LocalDateTime localDateTime : startAndEndTime) {
            localDateTimes.add(localDateTime.plusHours(8));
        }
        return localDateTimes;
    }

    public static Long getSecondTime(LocalDateTime startTime) {
        return startTime.toEpochSecond(ZoneOffset.of(ADAPT_OFFSET));

    }
}
