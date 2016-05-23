package com.ks.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class XyTimeUtil {

	/**日期格式(yyyy/MM/dd HH:mm)*/
	public static final SimpleDateFormat yyyyIMMIdd_HH_mm = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	/**日期格式(yyyy-MM-dd HH:mm:ss)*/
	public static final SimpleDateFormat yyyy_MM_dd_HH_mm_ss1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**日期格式(yyyy_MM_dd_HH_mm_ss)*/
	public static final SimpleDateFormat yyyy_MM_dd_HH_mm_ss2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	/**日期格式(yyyy-MM-dd)*/
	public static final SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	/**日期格式(HH:mm:ss)-1970年1月1日某个时间*/
	public static final SimpleDateFormat HH_mm_ss = new SimpleDateFormat("HH:mm:ss");
	/**日期格式(yyyy年MM月dd日)*/
	public static final SimpleDateFormat CHINA_yyyy_MM_dd = new SimpleDateFormat("yyyy年MM月dd日");
	/**日期格式(yyyy年MM月dd日HH时mm分ss秒)*/
	public static final SimpleDateFormat CHINA_yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
	/**秒*/
	public final static int SECOND = 1;
	/**分转化为秒*/
	public final static int MINUTE_SECOND = 60 * SECOND;
	/**时转化为秒*/
	public final static int HOUR_SECOND = 60 * MINUTE_SECOND;
	/**天转化为秒*/
	public final static int DAY_SECOND = 24 * HOUR_SECOND;
	/**周转化为秒*/
	public final static int WEEK_SECOND = 7 * DAY_SECOND;
	/**秒转化为毫秒*/
	public final static long SECOND_MILLIS = 1000;
	/**分转化为毫秒*/
	public final static long MINUTE_MILLIS = MINUTE_SECOND * SECOND_MILLIS;
	/**时转化为毫秒*/
	public final static long HOUR_MILLIS = 60 * MINUTE_MILLIS;
	/**天转化为毫秒*/
	public final static long DAY_MILLIS = 24 * HOUR_MILLIS;
	/**周转化为毫秒*/
	public final static long WEEK_MILLIS = 7 * DAY_MILLIS;

	/**
	 * 将时间转化成指定格式的String
	 */
	public static String format(Date date, SimpleDateFormat formater){
		return formater.format(date);
	}
	
	/**
	 * 将字符串按照指定格式解析成Date
	 */
	public static Date parse(String str, SimpleDateFormat formater){
		try{
			return formater.parse(str);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new Date();
	}
	
	/**
	 * 获取当前时间(秒)
	 */
	public static int getNowSecond(){
		return (int) (System.currentTimeMillis() / SECOND_MILLIS);
	}
	
	/**
	 * 获取当前时间(毫秒)
	 */
	public static long getNowMillis(){
		return System.currentTimeMillis();
	}
	
	/**
	 * 获取当前时间(日期)
	 */
	public static Date getNowDate(){
		return new Date();
	}
	
	/**
	 * 毫秒转化为秒
	 */
	private static int getTimeOfSecond(long millis){
		return (int) (millis / SECOND_MILLIS);
	}

	/**
	 * 日期转化为秒
	 */
	public static int getTimeOfSecond(Date date){
		return getTimeOfSecond(date.getTime());
	}
	
	/**
	 * 获取今日时分秒对应的秒数
	 */
	public static int getTimeOfSecond(int hour, int minute, int second){
		Date date = getDate(hour, minute, second);
		return getTimeOfSecond(date.getTime());
	}
	
	/**
	 * 秒转化为date
	 */
	public static Date getDate(int second){
		return getDate(second * SECOND_MILLIS);
	}
	
	/**
	 * 毫秒转化为date
	 */
	public static Date getDate(long millis){
		return new Date(millis);
	}
	
	/**
	 * 获取今日时分秒对应的date
	 */
	public static Date getDate(int hour, int minute, int second){
		Calendar calendar = Calendar.getInstance();
		return getDate(calendar, hour, minute, second);
	}
	
	/**
	 * 获取指定时分秒的某个时间
	 */
	public static Date getDate(Date date, int hour, int minute, int second){
		Calendar calendar = newCalendar(date);
		return getDate(calendar, hour, minute, second);
	}
	
	/**
	 * 获取date
	 */
	private static Date getDate(Calendar calendar, int hour, int minute, int second){
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取date同周同时分秒的周几(monthDay>当月最大天数类推到下月)
	 */
	public static Date getDateOfWeekDay(Date date, int weekDay){
		Calendar old = newCalendar(date);
		return getDateOfWeekDay(date, weekDay, old.get(Calendar.HOUR_OF_DAY), old.get(Calendar.MINUTE), old.get(Calendar.SECOND));
	}

	/**
	 * 获取date同周的周几时分秒(weekDay>7时类推到下周)
	 */
	public static Date getDateOfWeekDay(Date date, int weekDay, int hour, int minute, int second){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, weekDay + 1);
		int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if(day != weekDay){
			calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + weekDay - day);
		}
		return getDate(calendar, hour, minute, second);
	}

	/**
	 * 获取date同年同月同时分秒的某天(monthDay>当月最大天数类推到下月)
	 */
	public static Date getDateOfMonthDay(Date date, int monthDay){
		Calendar calendar = newCalendar(date);
		return getDateOfMonthDay(date, monthDay, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
	}
	
	/**
	 * 获取date同年同月的某天时分秒(monthDay>当月最大天数类推到下月)
	 */
	public static Date getDateOfMonthDay(Date date, int monthDay, int hour, int minute, int second){
		Calendar calendar = newCalendar(date);
		calendar.set(Calendar.DAY_OF_MONTH, monthDay);
		return getDate(calendar, hour, minute, second);
	}
	
	/**
	 * 获取该周几
	 */
	public static int getDayOfWeek(Date date){
		Calendar calendar = newCalendar(date);
		return getDayOfWeek(calendar);
	}
	
	/**
	 * 获取该周几
	 */
	private static int getDayOfWeek(Calendar calendar){
		int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if(day == 0){
			return 7;
		}
		return day;
	}

	/**
	 * 获取该月日数
	 */
	public static int getDayOfMonth(Date date){
		Calendar calendar = newCalendar(date);
		return calendar.get(Calendar.DATE);
	}
	
	/**
	 * 获取该月最大天数
	 */
	public static int getDayByMax(Date date){
		Calendar calendar = newCalendar(date);
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		return calendar.get(Calendar.DATE);
	}
	
	private static Calendar newCalendar(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * date1 在 date2 前返回true
	 */
	public static boolean before(Date date1, Date date2){
		return date1.before(date2);
	}

	/**
	 * time1在time2前返回true
	 */
	public static boolean before(int time1, int time2){
		return time1 < time2;
	}
	
	/**
	 * time1在time2前返回true
	 */
	public static boolean before(long time1, long time2){
		return time1 < time2;
	}

	/**
	 * 获取下一次执行时间
	 */
	public static Date getNextDateByExecute(Date date, int field, int amount){
		Calendar calendar = Calendar.getInstance();
		if(calendar.getTimeInMillis() < date.getTime()){
			return date;
		}else{
			Calendar calendar1 = newCalendar(date);
			calendar1.add(field, amount);
			while(calendar1.getTimeInMillis() < calendar.getTimeInMillis()){
				calendar1.add(field, amount);
			}
			return calendar1.getTime();
		}
	}

	/**
	 * 获取下个时间
	 */
	public static Date getNextDate(Date date, int field, int amount){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}
	
	/**
	 * 获取上次执行时间
	 */
	public static Date getLastDateByExecute(Date date, int field, int amount){
		Calendar calendar = Calendar.getInstance();
		if(calendar.getTimeInMillis() > date.getTime()){
			return date;
		}else{
			Calendar calendar1 = newCalendar(date);
			calendar1.add(field, -amount);
			while(calendar1.getTimeInMillis() > calendar.getTimeInMillis()){
				calendar1.add(field, -amount);
			}
			return calendar1.getTime();
		}
	}
	
	/**
	 * 获取上个时间
	 */
	public static Date getLastDate(Date date, int field, int amount){
		Calendar calendar = newCalendar(date);
		calendar.set(field, calendar.get(field) - amount);
		return calendar.getTime();
	}

	/**
	 * 获取间隔秒数
	 */
	public static int getIntervalOfSecond(Date date1, Date date2){
		if(before(date1, date2)){
			return getTimeOfSecond(date2) - getTimeOfSecond(date1);
		}
		return getTimeOfSecond(date1) - getTimeOfSecond(date2);
	}
	
	/**
	 * 获取间隔天数
	 */
	public static int getIntervalOfDay(Date date1, Date date2){
		return isSameDay(date1, date2) ? 0 : getInterval(date1, date2, 1, DAY_MILLIS);
	}
	
	/**
	 * 获取间隔周数
	 */
	public static int getIntervalOfWeekDay(Date date1, Date date2){
		return isSameWeek(date1, date2) ? 0 : getInterval(date1, date2, 7, WEEK_MILLIS);
	}
	
	/**
	 * 获取间隔(此方法不处理相同周期)
	 */
	private static int getInterval(Date date1, Date date2, int day, double millis){
		if(before(date1, date2)){
			return getInterval(date2, date1, millis);
		}else{
			return getInterval(date1, date2, millis);
		}
	}
	
	/**
	 * 获取间隔
	 */
	private static int getInterval(Date big, Date small, double millis){
		return (int) Math.ceil((big.getTime() - small.getTime()) / millis);
	}
	
	/**
	 * 是否同一天
	 */
	public static boolean isSameDay(Date date1, Date date2){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		int year1 = cal.get(Calendar.YEAR);
		int month1 = cal.get(Calendar.MONTH);
		int day1 = cal.get(Calendar.DAY_OF_YEAR);
		cal.setTime(date2);
		int year2 = cal.get(Calendar.YEAR);
		int month2 = cal.get(Calendar.MONTH);
		int day2 = cal.get(Calendar.DAY_OF_YEAR);
		return year1 == year2 && month1 == month2 && day1 == day2;
	}
	
	/**
	 * 是否同一周
	 */
	public static boolean isSameWeek(Date date1, Date date2){
		Date start = getDateOfWeekDay(date1, 1, 0, 0, 0);
		Date end = getDateOfWeekDay(date1, 7, 23, 59, 59);
		return before(start, date2) && before(date2, end);
	}
	
	/**
	 * 是否同月份
	 */
	public static boolean isSameMonth(Date date1, Date date2){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		int year1 = cal.get(Calendar.YEAR);
		int month1 = cal.get(Calendar.MONTH);
		cal.setTime(date2);
		int year2 = cal.get(Calendar.YEAR);
		int month2 = cal.get(Calendar.MONTH);
		return year1 == year2 && month1 == month2;
	}
	
	/**
	 * 是否开始
	 */
	public static boolean isStart(Date start, Date end){
		Date now = getNowDate();
		if(before(start, now)){
			return before(now, end);
		}
		return false;
	}
	
	/**************************其他*********************************/

	public static long getTime(String str) {
		if(str.length()>3){
			try {
				return yyyyIMMIdd_HH_mm.parse(str).getTime();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Long.parseLong(str);
	}
	

}
