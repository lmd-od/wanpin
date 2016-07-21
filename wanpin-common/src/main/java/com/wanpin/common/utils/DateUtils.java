package com.wanpin.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>日期处理工具类</p>
 * @author litr 2016年7月13日
 * @version 1.0
 */
public class DateUtils
{
	private static String defaultDatePattern = "yyyy-MM-dd";// 默认的年月日

	public static final String hour12HMSPattern = "yyyy-MM-dd hh:mm:ss";// 年月日 时分秒12小时制
	public static final String hour12HMPattern = "yyyy-MM-dd hh:mm"; // ...年月日 时分..12小时制
	public static final String hour12HPattern = "yyyy-MM-dd hh";// ........年月日 时....12小时制
	public static final String hour12HPatternMillisecond = "yyyy-MM-dd-hh-mm-ss-SSS";// ........年月日 时分秒毫秒....24小时制
	
	public static final String hour24HMSPattern = "yyyy-MM-dd HH:mm:ss";// 年月日 时分秒24小时制
	public static final String hour24HMPattern = "yyyy-MM-dd HH:mm";// ....年月日 时分..24小时制
	public static final String hour24HPattern = "yyyy-MM-dd HH";// ........年月日 时....24小时制
	public static final String hour24HPatternMillisecond = "yyyy-MM-dd-HH-mm-ss-SSS";// ........年月日 时分秒毫秒....24小时制

	/**
	 * 返回默认格式的当前日期
	 */
	public static String getToday(){
		Date today = new Date();
		return format(today);
	}

	/**
	 * 返回默认格式的当前时间戳字符串格式
	 */
	public static String getCurrentDate(){
		return format(new Date(), defaultDatePattern);
	}

	/**
	 * 返回指定 格式的当前时间戳字符串格式
	 */
	public static String getCurrentDate(String pattern){
		return format(new Date(), pattern);
	}

	/**
	 * 返回默认格式的当前时间戳
	 */
	public static Timestamp getCurrentTimestamp(){
		String timestamp = format(new Date(), hour24HMSPattern);
		return Timestamp.valueOf(timestamp);
	}

	/**
	 * 返回 默认格式下的前一天的日期
	 */
	public static String getYestoday(){
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());
		cal1.add(Calendar.DATE, -1);
		return format(cal1.getTime());
	}

	/**
	 * 取得当前日期所在月份的第一天
	 */
	public static String getFirstOfMonth(){
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());
		cal1.set(Calendar.DATE, 1);// 日，设为一号
		return format(cal1.getTime());
	}

	/**
	 * 取得指定日期所在月份的第一天
	 * @param strDate 指定的日期
	 * @return
	 * @throws ParseException
	 */
	public static String getFirstOfMonth(String strDate) throws ParseException{
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(parse(strDate));
		cal1.set(Calendar.DATE, 1);// 日，设为一号
		return format(cal1.getTime());
	}

	/**
	 * 取得某年某月的最后一天的日期
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getEndOfMonth(int year, int month)
	{
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, year);// 年
		cal1.set(Calendar.MONTH, month - 1);// 月，因为Calendar里的月是从0开始，所以要减1
		cal1.set(Calendar.DATE, 1);// 日，设为一号
		cal1.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
		cal1.add(Calendar.DATE, -1);// 下一个月减一为本月最后一天
		return format(cal1.getTime());// 获得月末是几号
	}

	// ******第三部分******************在String和Date之间转换*******************************

	/**
	 * 使用默认格式转换Date成字符串
	 * @param date
	 * @return
	 */
	public static String format(Date date){
		return format(date,defaultDatePattern);
	}

	/**
	 * 使用指定格式转换Date成字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern){
		String returnValue = "";
		if (date != null){
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return (returnValue);
	}

	/**
	 * 使用默认格式将字符串转为Date
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String strDate) throws ParseException{
		return parse(strDate,defaultDatePattern);
	}

	/**
	 * 使用指定格式将字符串转为Date
	 * @param strDate
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String strDate, String pattern) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.parse(strDate);
	}

	/**
	 * 转换日期字符串为Timestamp类型
	 * @param strTimestamp
	 * @return
	 */
	public static Timestamp convertStringToTimestamp(String strTimestamp){
		return Timestamp.valueOf(strTimestamp);
	}

	@SuppressWarnings("deprecation")
	public static String convertTimestampToString(Timestamp timestamp){
		Date date = new Date(timestamp.getYear(), timestamp.getMonth(), timestamp.getDay(), timestamp.getHours(), timestamp.getMinutes(), timestamp.getSeconds());
		return format(date,defaultDatePattern);
	}

	/**
	 * 在日期上月份加减(当n为负数时即为减)
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date addMonths(Date date, int n){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 在日期上天数加减(当n为负数时即为减)
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date addDays(Date date, int n){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	/**
	 * 在日期上天数加减(当n为负数时即为减)
	 * @param sdate
	 * @param n
	 * @return
	 * @throws ParseException
	 */
	public static String addDays(String sdate, int n) throws ParseException{
		Date inDate = parse(sdate);
		Date outDate = addDays(inDate, n);
		return format(outDate);
	}

	/**
	 * 返回当前年
	 * @return
	 */
	public static int getYear(){ 
	  Calendar c = Calendar.getInstance(); 
	  int yy = c.get(Calendar.YEAR); 
	  return yy; 
	} 

	/**
	 * 返回当前月
	 * @return
	 */
	public static int getMonth() { 
	  Calendar c = Calendar.getInstance(); 
	  int month = c.get(Calendar.MONTH); 
	  return month+1; 
	} 
 
	/**
	 * 返回当前日
	 * @return
	 */
	public static int getDate() { 
	  Calendar c = Calendar.getInstance(); 
	  int date = c.get(Calendar.DATE); 
	  return date; 
	}
	
	/**
     * 判断两个日期是否是同一天
     * @param date1
     *            date1
     * @param date2
     *            date2
     * @return
     */
	public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                        .get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }
}