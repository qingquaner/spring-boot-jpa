package com.chenhj.jpa.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/***
 * @Written by : Andy
 * @Creation Date : Dec 10, 2009 03:30:00 AM
 * @version : v3.00
 * @Description :
 * 
 *              <p>
 *              Copyright(c) chnbs 2009
 *              </p>
 ***/

public class DateTimeUtil {

	private static final int MAJOR_VERSION = 1;
	private static final int MINOR_VERSION = 0;
	private static final int REVISION_VERSION = 1;
	private static final String showFormat = "yyyy-MM-dd HH:mm:ss";
	private static final String storeFormat = "yyyyMMddHHmmssSSS";
	private static final String storeFormat1 = "yyyyMMddHHmmss";
	private static final SimpleDateFormat showFormater = new SimpleDateFormat(showFormat);
	private static final SimpleDateFormat storeFormater = new SimpleDateFormat(storeFormat);
	private static final SimpleDateFormat storeFormater1 = new SimpleDateFormat(storeFormat1);
	private static final SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
	private static final SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy年MM月dd日");
	private static final SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy/MM/dd");
	private static final SimpleDateFormat formatter6 = new SimpleDateFormat("MM-dd HH:mm");
	private static final SimpleDateFormat formatter7 = new SimpleDateFormat("yyyyMM");
	private static final SimpleDateFormat formatter8 = new SimpleDateFormat("yyyy");
	private static final SimpleDateFormat formatter9 = new SimpleDateFormat("HH:mm:ss");
	private static final SimpleDateFormat formatter10 = new SimpleDateFormat("MM");
	private static final SimpleDateFormat formatter11 = new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat formatter12 = new SimpleDateFormat("HH:mm");
	private static final SimpleDateFormat formatter13 = new SimpleDateFormat("yyyy/MM");
	private static final SimpleDateFormat formatter14 = new SimpleDateFormat("yyyy-MM");
	private static final SimpleDateFormat solrFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm s.SSS", Locale.US);
	public static TimeZone UTC = TimeZone.getDefault();

	public DateTimeUtil() {
	}

	public static String getNow() {
		return storeFormater.format(new Date());
	}

	public static String getNow1() {
		return storeFormater1.format(new Date());
	}

	public static String getRelativeDate(int days) {
		Calendar c = Calendar.getInstance();
		c.set(5, c.get(5) + days);
		StringBuffer sb = new StringBuffer(17);
		sb.append(c.get(1));
		int tmp[] = { c.get(2) + 1, c.get(5), c.get(11), c.get(12), c.get(13), c.get(14) };
		for (int i = 0; i < tmp.length - 1; i++)
			sb.append(tmp[i] >= 10 ? "" : "0").append(tmp[i]);

		if (tmp[tmp.length - 1] < 10)
			sb.append("0");
		if (tmp[tmp.length - 1] < 100)
			sb.append("0");
		sb.append(tmp[tmp.length - 1]);
		return sb.toString();
	}

	public static String getNow(String string) {
		return (new SimpleDateFormat(string)).format(new Date());
	}

	public static String getDisplayTime(long time) {
		return showFormater.format(new Date(time));
	}

	public static String getDisplayTime(long time, String string) {
		return (new SimpleDateFormat(string)).format(new Date(time));
	}

	public static String getShowFormat(String time) {
		try {
			if (time == null || time.equals(""))
				time = showFormater.format(new Date());
			else
				time = showFormater.format(storeFormater.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * 
	 * @Description (判断当时间是否在本月) @param time 2012-08-30 20:14:54 @return @return
	 *              boolean @throws
	 */
	public static boolean isCurrentMonth(String time) {
		boolean result = false;
		String now = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		now = formatter.format(new Date());// 系统当前时间
		// 取出月份
		time = time.substring(5, 7);
		now = now.substring(5, 7);
		if (time.equals(now)) {
			result = true;
		}
		return result;
	}

	public static long compare(String t1, String t2) {
		return Long.valueOf(t1).longValue() - Long.valueOf(t2).longValue();
	}

	public static int getYear(String time) {
		return Integer.valueOf(time.substring(0, 4)).intValue();
	}

	public static int getMonth(String time) {
		return Integer.valueOf(time.substring(4, 6)).intValue();
	}

	public static int getDate(String time) {
		return Integer.valueOf(time.substring(6, 8)).intValue();
	}

	public static int getHour(String time) {
		return Integer.valueOf(time.substring(8, 10)).intValue();
	}

	public static int getMinute(String time) {
		return Integer.valueOf(time.substring(10, 12)).intValue();
	}

	public static int getSecond(String time) {
		return Integer.valueOf(time.substring(12, 14)).intValue();
	}

	public static int getMilliSencond(String time) {
		return Integer.valueOf(time.substring(14, 17)).intValue();
	}

	public static long getTimeStamp(String time) throws ParseException {
		return storeFormater.parse(time).getTime();
	}

	public static String formatDate1(Date myDate) {
		return formatter1.format(myDate);
	}

	public static String formatDate2(Date myDate) {
		return formatter2.format(myDate);
	}

	public static String formatDate3(Date myDate) {
		return formatter3.format(myDate);
	}

	public static String formatDate4(Date myDate) {
		return formatter4.format(myDate);
	}

	public static String formatDate5(Date myDate) {
		return formatter5.format(myDate);
	}

	public static String formatDate6(Date myDate) {
		return formatter6.format(myDate);
	}

	public static String formatDate7(Date myDate) {
		return formatter7.format(myDate);
	}

	public static String formatDate8(Date myDate) {
		return formatter8.format(myDate);
	}

	public static String formatDate9(Date myDate) {
		return formatter9.format(myDate);
	}

	public static String formatDate10(Date myDate) {
		return formatter10.format(myDate);
	}

	public static String formatDate11(Date myDate) {
		return formatter11.format(myDate);
	}

	public static String formatDate12(Date myDate) {
		return formatter12.format(myDate);
	}

	public static String formatDate13(Date myDate) {
		return formatter13.format(myDate);
	}

	public static String formatDate14(Date myDate) {
		return formatter14.format(myDate);
	}

	public static String solrFormatter(long d) {
		Date myDate = new java.util.Date(d);
		solrFormatter.setTimeZone(UTC);
		return solrFormatter.format(myDate);
	}

	public static long getLongTime(String time) {
		try {
			return showFormater.parse(time).getTime();
		} catch (ParseException ex) {
			return 0L;
		}
	}

	public static long getDateTime(String time) {
		try {
			return formatter3.parse(time).getTime();
		} catch (ParseException ex) {
			return 0L;
		}
	}

	public static long getTime(String time) {
		try {
			return formatter4.parse(time).getTime();
		} catch (ParseException ex) {
			return 0L;
		}
	}

	public static String getyyyyMMdd(String time) {
		try {
			long l4 = formatter4.parse(time).getTime();
			return formatter4.format(new Date(l4));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static long getTime(String time, String flag) {
		StringBuffer sb = new StringBuffer();
		sb.append(time);
		if (flag.equalsIgnoreCase("start")) {
			sb.append(" ").append("00:00:00");
		} else if (flag.equalsIgnoreCase("end")) {
			sb.append(" ").append("23:59:59");
		}
		return getLongTime(sb.toString());
	}

	public static String getTimeDate(String time, String flag) {
		StringBuffer sb = new StringBuffer();
		sb.append(time);
		if (flag.equalsIgnoreCase("start")) {
			sb.append(" ").append("00:00:00");
		} else if (flag.equalsIgnoreCase("end")) {
			sb.append(" ").append("23:59:59");
		}
		return sb.toString();
	}

	public static long getYearTime(String time, String flag) {
		StringBuffer sb = new StringBuffer();
		sb.append(time);
		if (flag.equalsIgnoreCase("start")) {
			sb.append("-01-01 00:00:00");
		} else if (flag.equalsIgnoreCase("end")) {
			sb.append("-12-30 23:59:59");
		}
		return getLongTime(sb.toString());
	}

	/**
	 * 得到本月的第一天
	 * 
	 * @return
	 */
	public static long getMonthFirstDay() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime().getTime();
	}

	public static long getMonthFirstDay(long l) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(l));
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime().getTime();
	}

	/**
	 * 取某个时间后某天的时间
	 * 
	 * @param strTime
	 *            某个时间
	 * @param i
	 *            后几天数（向前为负数）
	 * @return
	 */
	public static String printNextTime(String strTime, int i) {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		try {
			date = formatter3.parse(strTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.setTime(date);
		cal.add(Calendar.DATE, i);
		return formatter3.format(cal.getTime());

	}

	/**
	 * 上个月的今天
	 * 
	 * @return
	 */
	public static String getLastMonthCurrentDay() {
		// Date Format will be display
		SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		GregorianCalendar aGregorianCalendar = new GregorianCalendar();
		// Get last month GregorianCalendar object
		aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) - 1);
		// Format the date to get year and month
		String nowOfLastMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
		return nowOfLastMonth;
	}

	/**
	 * 得到本月的最后一天
	 * 
	 * @return
	 */
	public static long getMonthLastDay() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime().getTime();
	}

	public static long getMonthLastDay(long l) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(l));
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime().getTime();
	}

	/**
	 * 返回某月多少天
	 * 
	 * @param strDate（yyyyMM）
	 * @return
	 * @throws ParseException
	 */
	public static int getMonthDay(String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Calendar calendar = new GregorianCalendar();
		Date date = sdf.parse(strDate);
		calendar.setTime(date);
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return day;
	}

	public static String getVersion() {
		return "1.0.1";
	}

	public static int getMajor() {
		return MAJOR_VERSION;
	}

	public static int getMinor() {
		return MINOR_VERSION;
	}

	public static int getRevision() {
		return REVISION_VERSION;
	}

	// 上个月的今天
	public static String getNowOfLastMonth() {
		// Date Format will be display
		SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		GregorianCalendar aGregorianCalendar = new GregorianCalendar();
		// Get last month GregorianCalendar object
		aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) - 1);
		// Format the date to get year and month
		String nowOfLastMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
		return nowOfLastMonth;
	}

	// 上个月的今天
	public static String getNowOfLastMonthTow() {
		// Date Format will be display
		SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar aGregorianCalendar = new GregorianCalendar();
		// Get last month GregorianCalendar object
		aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) - 1);
		// Format the date to get year and month
		String nowOfLastMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
		return nowOfLastMonth;
	}

	// 去年的现在
	public static String getNowOfLastYear() {
		// Date Format will be display
		SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar aGregorianCalendar = new GregorianCalendar();
		// Get last month GregorianCalendar object
		aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar.get(Calendar.YEAR) - 1);
		// Format the date to get year and month
		String currentYearAndMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
		return currentYearAndMonth;
	}

	/**
	 * 
	 * 判断是否在某个时间段内**
	 * 
	 * @param before
	 *            开始时间
	 * @param after
	 *            结束时间
	 * @param d
	 *            需判断时间
	 * @author zouxb
	 */
	public static boolean isBetween(String before, String after, String d) {
		boolean flag = false;

		try {
			Calendar ca1 = Calendar.getInstance();
			ca1.setTime(formatter4.parse(before));
			Calendar ca2 = Calendar.getInstance();
			ca2.setTime(formatter4.parse(after));
			Calendar ca3 = Calendar.getInstance();
			ca3.setTime(formatter4.parse(d));

			if (ca3.after(ca1) && ca3.before(ca2)) {
				flag = true;
			}
			if (before.equals(d) || after.equals(d)) {
				flag = true;
			}
		}

		catch (ParseException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean isBetween2(Date before, Date after, Date d) {
		boolean flag = false;

		try {
			if (d.after(before) && d.before(after))
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
