package com.util;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by baijian.dzw on 15/11/16.
 */
public class DateUtils {
    /**
     * 时间原点：2010-01-01 00:00:00 UTC
     */
    public static final long TIME_ORIGIN = 1262275200000L;

    public static final long BEIJING_TIME_ORIGIN = 1262275200000l;
    /**
     * 2009-12-08 14:52:50
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String SHORT_DATETIME_FORMAT = "yyyyMMddHHmmss";

    public static final String DEFAULT_DATETIME_FORMAT_NO_SECOND = "yyyy-MM-dd HH:mm";

    public static final String SHORT_SLASH_FORMAT = "yyyy/MM/dd";
    /**
     * 2009-12-08T14:52:50
     */
    public static final String ISO_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * 2009-12-08T14:52:50+08:00
     */
    public static final String ISO_DATETIME_TIME_ZONE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZ";

    /**
     * 2009-12-08
     */
    public static final String ISO_DATE_FORMAT = "yyyy-MM-dd";
    public static final String ZW_DATE_FORMAT = "yyyy年MM月dd日";

    public static final String SHORT_DATE_FORMAT = "yyyyMMdd";

    /**
     * 2009-12-08+08:00
     */
    public static final String ISO_DATE_TIME_ZONE_FORMAT = "yyyy-MM-ddZZ";

    /**
     * T14:52:50
     */
    public static final String ISO_TIME_FORMAT = "'T'HH:mm:ss";

    /**
     * T14:52:50+08:00
     */
    public static final String ISO_TIME_TIME_ZONE_FORMAT = "'T'HH:mm:ssZZ";

    /**
     * 14:52:50
     */
    public static final String ISO_TIME_NO_T_FORMAT = "HH:mm:ss";

    /**
     * 14:52:50+08:00
     */
    public static final String ISO_TIME_NO_T_TIME_ZONE_FORMAT = "HH:mm:ssZZ";

    /**
     * 星期二, 08 十二月 2009 14:52:50 +0800
     */
    public static final String SMTP_DATETIME_FORMAT = "EEE, dd MMM yyyy HH:mm:ss Z";

    /**
     * @param timestamp 要转换的时间
     * @return 自时间原点（{@link #TIME_ORIGIN}）开始的天数，例如，原点之后的一天返回1
     */
    public static short getDaysSinceTimeOrigin(Date timestamp) {
        return getDaysSinceTimeOrigin(timestamp.getTime());
    }

    /**
     * @param timestamp 要转换的时间，单位：milliSecond
     * @see #getDaysSinceTimeOrigin(Date)
     */
    public static short getDaysSinceTimeOrigin(long timestamp) {
        return (short) ((timestamp - TIME_ORIGIN) / (24 * 60 * 60 * 1000));
    }

    /**
     * @param timestamp 要转换的时间
     * @return 计算时间中小时和分钟部分以30分钟为单位的数额（范围：0 ~ 47）：如 03:35 为 7, 03:15 为 6
     */
    public static byte getHalfHour(Date timestamp) {
        return getHalfHour(timestamp.getTime());
    }

    /**
     * @param timestamp 要转换的时间，单位：milliSecond
     * @see #getHalfHour(Date)
     */
    public static byte getHalfHour(long timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        int m = cal.get(Calendar.MINUTE);
        return (byte) ((h << 1) + (m >= 30 ? 1 : 0));
    }

    /**
     * @param daysSinceTimeOrigin 自时间原点开始的天数，参考{@link #getDaysSinceTimeOrigin(Date)}
     *                            的返回，如果传入-1，直接返回null
     * @param halfHour            半小时的数量，参考{@link #getHalfHour(Date)}的返回，如果传入-1，则代表未指定小时和分钟信息
     * @return 将自时间原点开始的天数和半小时的数量转换为日期，假设时间原点为 2010-01-01，则将 (1,15) 转换为
     * 2010-01-02 07:30，而将 (1,14) 转换为 2010-01-02 07:00
     */
    public static Date getDate(short daysSinceTimeOrigin, byte halfHour) {
        return daysSinceTimeOrigin == -1 ? null : new Date((TIME_ORIGIN + daysSinceTimeOrigin * (long) (24 * 60 * 60 * 1000)) + (halfHour == -1 ? 0 : ((halfHour >> 1) * (60 * 60 * 1000) + (halfHour % 2 != 0 ? 30 : 0) * (60 * 1000))));
    }

    /**
     * @since 1.1.3
     */
    public static Date getDate(short daysSinceTimeOrigin) {
        return getDate(daysSinceTimeOrigin, (byte) 0);
    }

    /**
     * @since 1.1.3
     */
    public static long getTime(short daysSinceTimeOrigin, byte halfHour) {
        return daysSinceTimeOrigin == -1 ? 0 : (TIME_ORIGIN + daysSinceTimeOrigin * (long) (24 * 60 * 60 * 1000)) + (halfHour == -1 ? 0 : ((halfHour >> 1) * (60 * 60 * 1000) + (halfHour % 2 != 0 ? 30 : 0) * (60 * 1000)));
    }

    /**
     * @since 1.1.3
     */
    public static long getTime(short daysSinceTimeOrigin) {
        return getTime(daysSinceTimeOrigin, (byte) 0);
    }

    public static String format(long millis, String pattern) {
        return format(new Date(millis), pattern, null, null);
    }

    public static String format(Date date) {
        return format(date, DEFAULT_DATETIME_FORMAT);
    }

    public static String format(Date date, String pattern) {
        return format(date, pattern, null, null);
    }

    public static String format(Calendar calendar, String pattern) {
        return format(calendar, pattern, null, null);
    }

    public static String format(long millis, String pattern, TimeZone timeZone) {
        return format(new Date(millis), pattern, timeZone, null);
    }

    public static String format(Date date, String pattern, TimeZone timeZone) {
        return format(date, pattern, timeZone, null);
    }

    public static String format(Calendar calendar, String pattern, TimeZone timeZone) {
        return format(calendar, pattern, timeZone, null);
    }

    public static String format(long millis, String pattern, Locale locale) {
        return format(new Date(millis), pattern, null, locale);
    }

    public static String format(Date date, String pattern, Locale locale) {
        return format(date, pattern, null, locale);
    }

    public static String format(Calendar calendar, String pattern, Locale locale) {
        return format(calendar, pattern, null, locale);
    }

    public static String format(long millis, String pattern, TimeZone timeZone, Locale locale) {
        return format(new Date(millis), pattern, timeZone, locale);
    }

    public static String format(Date date, String pattern, TimeZone timeZone, Locale locale) {
        if (date == null) {
            return null;
        }
        FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale);
        return df.format(date);
    }

    public static String format(Calendar calendar, String pattern, TimeZone timeZone, Locale locale) {
        FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale);
        return df.format(calendar);
    }

    public static Date parse(String date) throws ParseException {
        return parse(date, DEFAULT_DATETIME_FORMAT);
    }

    public static Date parse(String date, String pattern) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.parse(date);
    }

    public static Date getEndOfDay(Date day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getStartOfDay(Date day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static Date getStartOfDayBeforeNow(int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }

    public static Date getNoonOfDay(Date day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static Date getStartOfMonth(Date day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static Date getEndOfMonth(Date day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    /**
     * 返回小时：分：秒
     *
     * @param second
     * @return
     */
    public static String getTimeString(int second) {
        int HOUR = 60 * 60;
        // int t = 6036;
        int h = second / HOUR;
        int m = (second % HOUR) / 60;
        int s = second % 60;
        return addZero(h) + ":" + addZero(m) + ":" + addZero(s);
    }

    public static String timeIntToString(int seconds) {
        StringBuffer result = new StringBuffer("");
        if (seconds > 3600) { // hour:min:sec
            int hour = seconds / 3600;
            int min = (seconds - hour * 3600) / 60;
            int sec = seconds - hour * 3600 - min * 60;

            if (hour < 10) {
                result.append("0").append(hour);
            } else {
                result.append(hour);
            }
            result.append(":");

            if (min < 10) {
                result.append("0").append(min);
            } else {
                result.append(min);
            }
            result.append(":");

            if (sec < 10) {
                result.append("0").append(sec);
            } else {
                result.append(sec);
            }

        } else if (seconds > 0) {
            int min = seconds / 60;
            int sec = seconds - min * 60;

            if (min < 10) {
                result.append("0").append(min);
            } else {
                result.append(min);
            }
            result.append(":");
            if (sec < 10) {
                result.append("0").append(sec);
            } else {
                result.append(sec);
            }
        } else {
            result = new StringBuffer("-1");
        }
        return result.toString();
    }

    public static String getFriendlyTimeDiff(Date now) {
        return getFriendlyTimeDiff(now.getTime(), System.currentTimeMillis());
    }

    public static String getFriendlyTimeDiff(long time, long timeNow) {
        long diff = timeNow - time;
        String str = "";
        if (diff > 0) {
            long s = diff / (60 * 1000);
            long h = s / 60;
            long d = h / 24;
            long m = d / 30;
            long y = m / 12;
            if (y > 0) {
                str = y + "年前";
            } else if (m > 0) {
                str = m + "月前";
            } else if (d > 0) {
                str = d + "天前";
            } else if (h > 0) {
                str = h + "小时前";
            } else if (s > 0) {
                str = s + "分钟前";
            } else {
                str = "刚刚";
            }
        }
        return str;
    }

    public static String getFriendlyTimeDiff2(long time, long timeNow) {
        long diff = timeNow - time;
        String str = "";
        if (diff > 0) {
            long s = diff / (60 * 1000);
            long h = s / 60;
            long d = h / 24;
            long m = d / 30;
            long y = m / 12;
            if (y > 0) {
                str = DateUtils.format(time, ISO_DATE_FORMAT) + "日";
            } else if (m > 0) {
                str = DateUtils.format(time, ISO_DATE_FORMAT) + "日";
            } else if (d > 0) {
                str = d + "天前";
            } else if (h > 0) {
                str = h + "小时前";
            } else if (s > 0) {
                str = s + "分钟前";
            } else {
                str = "刚刚";
            }
        }
        return str;
    }

    public static final String addZero(int i) {
        return i < 10 ? "0" + i : "" + i;
    }

    public static String calcHMS(long timeInSeconds) {
        long hours, minutes, seconds;
        timeInSeconds = timeInSeconds / 1000;
        hours = timeInSeconds / 3600;
        timeInSeconds = timeInSeconds - (hours * 3600);
        minutes = timeInSeconds / 60;
        timeInSeconds = timeInSeconds - (minutes * 60);
        seconds = timeInSeconds;
        return hours + " hour(s) " + minutes + " minute(s) " + seconds + " second(s)";
    }

    /**
     * 是否超时
     *
     * @param standard 基准
     * @param d2       比较时间
     * @return
     */
    public static boolean isTimeout(long standard, long d2, int delaySecond) {
        if (standard - d2 > delaySecond * 1000) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 是否在n天内
     *
     * @param day
     * @param current
     * @return
     */
    public static boolean inDays(int day, Date current) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, -day);
        return now.getTime().before(current);
    }

    /**
     * 返回两天间隔
     *
     * @param d1
     * @param d2
     * @return
     */
    public static short getIntervalDays(Date d1, Date d2) {
        short t1 = getDaysSinceTimeOrigin(d1);
        short t2 = getDaysSinceTimeOrigin(d2);
        return (short) (t1 - t2);
    }

    public static Date plusDay(Date d1, int days) {
        if (days == 0) {
            return d1;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static Date plusTime(Date d1, long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(d1.getTime() + time);
        return cal.getTime();
    }

    public static Date subDay(Date d1, int days) {
        if (days == 0) {
            return d1;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * 两个日期的天数差，1月3日和1月1日差2天
     *
     * @param d1
     * @param d2
     * @return
     */
    public static int dayDiff(Date d1, Date d2) {
        return getDaysSinceTimeOrigin(d1) - getDaysSinceTimeOrigin(d2);
    }

    public static List<Integer> getMonthInYear(Date startTime, Date endTime, int currentYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endTime);
        int endMonth = calendar.get(Calendar.MONTH) + 1;
        calendar.setTime(startTime);
        List<Integer> months = new ArrayList<Integer>();
        if (startTime.after(endTime)) {
            return months;
        }
        while (true) {
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);
            if (year != currentYear) {
                break;
            }
            if (calendar.getTime().after(endTime) && (month != endMonth)) {
                break;
            }
            months.add(month);
            calendar.add(Calendar.MONTH, 1);
        }
        return months;
    }

    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static int getMJWeekDay(Date date) {
        return mapToInnerWeekDay(getDayOfWeek(date));
    }

    public static int mapToInnerWeekDay(int weekDay) {
        return (weekDay + 5) % 7;
    }

    public static boolean isWeekend(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    public static boolean isWeekday(Date date) {
        return !isWeekend(date);
    }

    public static boolean withinPeriod(Date start, Date end) {
        return start.getTime() <= System.currentTimeMillis() && end.getTime() >= System.currentTimeMillis();
    }

    public static boolean withinPeriod(Date start, Date end, Date date) {
        return start.getTime() <= date.getTime() && end.getTime() >= date.getTime();
    }

    public static Integer getYesterday() {
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DAY_OF_MONTH, -1);
      String date = DateUtils.format(cal.getTime(), SHORT_DATE_FORMAT);
      return Integer.valueOf(date);
  }
    
    /**
     * 检查一个日期的时间是否落在某个区间
     *
     * @param start         开始时间 （单位秒）
     * @param end           结束时间 （单位秒）
     * @param someTimeToday 今天某一时刻
     * @return
     */
    public static boolean withinTime(long start, long end, Date someTimeToday) {
        long timeDelta = getSecsFromStartOfDay(someTimeToday);
        return start <= timeDelta && end >= timeDelta;
    }

    public static int getSecsFromStartOfDay(Date someTime) {
        return (int) (someTime.getTime() - getStartOfDay(someTime).getTime()) / 1000;
    }

    public static int getMinsFromStartOfDay(Date someTime) {
        return (int) (someTime.getTime() - getStartOfDay(someTime).getTime()) / 1000 / 60;
    }

    public static boolean isOneDay(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c1.get(Calendar.DATE) == c2.get(Calendar.DATE);
    }
    
    /**
     * 得到某天的0点
     * 
     * @return
     */
    public static Date getDateTime(int day) {
        Calendar cal = Calendar.getInstance();
        cal.roll(Calendar.DAY_OF_YEAR, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    /**
     * 得到某天的23:59:59点
     * @param day
     * @return
     */
    public static Date getDateTime24(int day) {
      Calendar cal = Calendar.getInstance();
      cal.roll(Calendar.DAY_OF_YEAR, day);
      cal.set(Calendar.HOUR_OF_DAY, 23);
      cal.set(Calendar.MINUTE, 59);
      cal.set(Calendar.SECOND, 59);
      cal.set(Calendar.MILLISECOND, 0);
      return cal.getTime();
  }

    public static boolean isOneDay(Date date, Date date2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        return isOneDay(c1, c2);
    }

    public static boolean checkDateFormat(String date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            Date d = dateFormat.parse(date);
            return date.equals(dateFormat.format(d));
        } catch (ParseException ex) {
            return false;
        }
    }

    public static  String getDateByFormat(String format){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }

    public static int compareDateStr(String date1,String date2,String format) throws  ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        Date bt=sdf.parse(date1);
        Date et=sdf.parse(date2);
        return  bt.compareTo(et);
    }

    public static  Date getDateByDateAndFormat(Date date,String format) throws ParseException{
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        String datestr=DateUtils.format(date,format);
        return simpleDateFormat.parse(datestr);
    }


    public static  Date getDateByFormat1(String format) throws ParseException{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            String datestr = DateUtils.format(new Date(), format);
           return  simpleDateFormat.parse(datestr);
    }

    public static boolean isTimeOverlapped(Date startTime1, Date endTime1, Date startTime2, Date endTime2){
        Assert.notNull(startTime1);
        Assert.notNull(endTime1);
        Assert.notNull(startTime2);
        Assert.notNull(endTime2);

        if((startTime1.equals(startTime2) || startTime1.after(startTime2)) && (startTime1.equals(endTime2) || startTime1.before(endTime2))){
            return true;
        }
        if((endTime1.equals(startTime2) || endTime1.after(startTime2)) && (endTime1.equals(endTime2) || endTime1.before(endTime2))){
            return true;
        }
        if((startTime2.equals(startTime1) || startTime2.after(startTime1)) && (startTime2.equals(endTime1) || startTime2.before(endTime1))){
            return true;
        }
        if((endTime2.equals(startTime1) || endTime2.after(startTime1)) && (endTime2.equals(endTime1) || endTime2.before(endTime1))){
            return true;
        }
        return false;
    }

    public static Date getFormatDate(){
        Date date;
        try {
            date = DateUtils.getDateByDateAndFormat(new Date(), DateUtils.ISO_DATE_FORMAT);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String[] s) throws ParseException {
//        Calendar cal = Calendar.getInstance();
//        int currentMonth = cal.get(Calendar.MONTH) + 1;
//        System.out.println(currentMonth);
//        System.out.println(getMonthInYear(parse("2015-06-12 00:09:00", "yyyy-MM-dd HH:mm:ss"), parse("2015-12-11 00:09:00", "yyyy-MM-dd HH:mm:ss"), 2015));

        Date et = new Date();
        String dateStr = DateUtils.format(et, DateUtils.ISO_DATE_FORMAT);

        System.out.println(DateUtils.getStartOfDay(et));
        System.out.println(DateUtils.getEndOfDay(et));


        Date s1 = DateUtils.parse("2015-06-12 01:09:00");
        Date e1 = DateUtils.parse("2015-06-12 11:09:00");

        Date s2 = DateUtils.parse("2015-06-12 01:09:00");
        Date e2 = DateUtils.parse("2015-06-12 11:01:00");

        System.out.println("1:true:" + isTimeOverlapped(s1, e1, s2, e2));
System.out.println("Felix ISO_DATE_FORMAT = "+getDateByDateAndFormat(new Date(),DateUtils.ISO_DATE_FORMAT));
        s1 = DateUtils.parse("2015-06-12 01:09:00");
        e1 = DateUtils.parse("2015-06-12 11:09:00");

        s2 = DateUtils.parse("2015-06-12 01:09:00");
        e2 = DateUtils.parse("2015-06-12 11:09:00");

        System.out.println("2:true" + isTimeOverlapped(s1, e1, s2, e2));

        s1 = DateUtils.parse("2015-06-12 01:09:00");
        e1 = DateUtils.parse("2015-06-12 11:09:00");

        s2 = DateUtils.parse("2015-06-12 01:09:00");
        e2 = DateUtils.parse("2015-06-12 11:10:00");

        System.out.println("3 true:" + isTimeOverlapped(s1, e1, s2, e2));

        s1 = DateUtils.parse("2015-06-12 01:09:00");
        e1 = DateUtils.parse("2015-06-12 11:09:00");

        s2 = DateUtils.parse("2015-06-12 01:10:00");
        e2 = DateUtils.parse("2015-06-12 11:08:00");

        System.out.println("4 true:" + isTimeOverlapped(s1, e1, s2, e2));

        s1 = DateUtils.parse("2015-06-12 01:09:00");
        e1 = DateUtils.parse("2015-06-12 11:09:00");

        s2 = DateUtils.parse("2015-06-12 01:10:00");
        e2 = DateUtils.parse("2015-06-12 11:09:00");

        System.out.println("5 true:" + isTimeOverlapped(s1, e1, s2, e2));

        s1 = DateUtils.parse("2015-06-12 01:09:00");
        e1 = DateUtils.parse("2015-06-12 11:09:00");

        s2 = DateUtils.parse("2015-06-12 01:10:00");
        e2 = DateUtils.parse("2015-06-12 11:11:00");

        System.out.println("6 true:" + isTimeOverlapped(s1, e1, s2, e2));

        s1 = DateUtils.parse("2015-06-12 01:09:00");
        e1 = DateUtils.parse("2015-06-12 11:09:00");

        s2 = DateUtils.parse("2015-06-12 11:09:00");
        e2 = DateUtils.parse("2015-06-12 11:11:00");

        System.out.println("7 true:" + isTimeOverlapped(s1, e1, s2, e2));

        s1 = DateUtils.parse("2015-06-12 01:09:00");
        e1 = DateUtils.parse("2015-06-12 11:09:00");

        s2 = DateUtils.parse("2015-06-12 11:10:00");
        e2 = DateUtils.parse("2015-06-12 11:11:00");

        System.out.println("8 false:" + isTimeOverlapped(s1, e1, s2, e2));

        s1 = DateUtils.parse("2015-06-12 05:09:00");
        e1 = DateUtils.parse("2015-06-12 11:09:00");

        s2 = DateUtils.parse("2015-06-12 01:10:00");
        e2 = DateUtils.parse("2015-06-12 04:11:00");

        System.out.println("9 false:" + isTimeOverlapped(s1, e1, s2, e2));

        s1 = DateUtils.parse("2015-06-12 05:09:00");
        e1 = DateUtils.parse("2015-06-12 11:09:00");

        s2 = DateUtils.parse("2015-06-12 01:10:00");
        e2 = DateUtils.parse("2015-06-12 05:09:00");

        System.out.println("9 true:" + isTimeOverlapped(s1, e1, s2, e2));

        s1 = DateUtils.parse("2015-06-12 05:09:00");
        e1 = DateUtils.parse("2015-06-12 11:09:00");

        s2 = DateUtils.parse("2015-06-12 01:10:00");
        e2 = DateUtils.parse("2015-06-12 06:09:00");

        System.out.println("9 true:" + isTimeOverlapped(s1, e1, s2, e2));
    }
}
